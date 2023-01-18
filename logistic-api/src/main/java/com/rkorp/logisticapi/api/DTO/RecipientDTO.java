package com.rkorp.logisticapi.api.DTO;

import lombok.Data;

@Data
public class RecipientDTO {

    private String name;
    private String address;
    private String number;
    private String complement;
    private String district;
}
