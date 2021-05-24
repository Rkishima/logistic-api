package br.com.rkishima.api.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<Problem.Field> fieldList = new ArrayList<>();
        Problem problem = new Problem();

        for (ObjectError errors : ex.getBindingResult().getAllErrors()){
            String fieldName = ((FieldError) errors).getField();
            String message = errors.getDefaultMessage();

            fieldList.add(new Problem.Field(fieldName, message));
            //6 - 16:34

        }

        problem.setStatus(status.value());
        problem.setDateTime(LocalDateTime.now());
        problem.setTitle("Um ou mais campos inválidos. Faça o preenchimento correto e " +
                "tente novamente");
        problem.setFields(fieldList);

        return handleExceptionInternal(ex, problem, headers, status, request);
    }
}
