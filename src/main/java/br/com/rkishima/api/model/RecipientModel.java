package br.com.rkishima.api.model;

import lombok.Data;

@Data
public class RecipientModel {
    private String name;
    private String publicPlace;
    private String number;
    private String complement;
    private String district;
}
