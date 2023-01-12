package com.rkorp.logisticapi.api.model.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class RecipientInput {
    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String number;

    @NotBlank
    private String complement;

    @NotBlank
    private String district;
}
