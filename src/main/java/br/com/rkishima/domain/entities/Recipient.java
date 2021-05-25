package br.com.rkishima.domain.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Data
@Embeddable
public class Recipient {

    @NotBlank
    @Column(name = "recipient_name")
    private String name;

    @NotBlank
    @Column(name = "recipient_public_place")
    private String publicPlace;

    @NotBlank
    @Column(name = "recipient_number")
    private String number;

    @NotBlank
    @Column(name = "recipient_complement")
    private String complement;

    @NotBlank
    @Column(name = "recipient_district")
    private String district;
}
