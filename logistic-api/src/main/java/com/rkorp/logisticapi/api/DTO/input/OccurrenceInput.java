package com.rkorp.logisticapi.api.DTO.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OccurrenceInput {

    @NotBlank
    private String description;
}
