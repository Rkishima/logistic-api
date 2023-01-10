package com.rkorp.logisticapi.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Recipient {

    @Column(name = "recipient_name")
    private String name;
    @Column(name = "recipient_address")
    private String address;
    @Column(name = "recipient_number")
    private String number;
    @Column(name = "recipient_complement")
    private String complement;
    @Column(name = "recipient_district")
    private String district;

}
