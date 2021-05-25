package br.com.rkishima.api.exceptionhandler;

import br.com.rkishima.domain.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<Problem.Field> fieldList = new ArrayList<>();
        Problem problem = new Problem();

        for (ObjectError errors : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) errors).getField();
            String message = messageSource.getMessage(errors, LocaleContextHolder.getLocale());

            fieldList.add(new Problem.Field(fieldName, message));

        }

        problem.setStatus(status.value());
        problem.setDateTime(LocalDateTime.now());
        problem.setTitle("Um ou mais campos inválidos. Faça o preenchimento correto e " +
                "tente novamente");
        problem.setFields(fieldList);

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusiness(BusinessException exception, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Problem problem = new Problem();
        problem.setStatus(status.value());
        problem.setDateTime(LocalDateTime.now());
        problem.setTitle(exception.getMessage());

        return handleExceptionInternal(exception, problem, new HttpHeaders(), status, request);
        //                             execption, body, headers, status, request(vem do WebRequest)

    }
}
