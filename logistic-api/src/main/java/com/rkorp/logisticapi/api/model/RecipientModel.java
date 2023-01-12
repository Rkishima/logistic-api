package com.rkorp.logisticapi.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
public class RecipientModel {

    private String name;
    private String address;
    private String number;
    private String complement;
    private String district;
}
