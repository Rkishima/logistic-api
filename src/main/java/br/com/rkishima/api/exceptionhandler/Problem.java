package br.com.rkishima.api.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Problem {
    private Integer status;
    private LocalDateTime dateTime;
    private String title;
    private List<Field> fields;


    @AllArgsConstructor
    @Getter
    public static class Field {
        private String fieldName;
        private String message;
    }

}
