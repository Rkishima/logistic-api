package br.com.rkishima.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Problem {
    private Integer status;
    private OffsetDateTime dateTime;
    private String title;
    private List<Field> fields;


    @AllArgsConstructor
    @Getter
    public static class Field {
        private String fieldName;
        private String message;
    }

}
