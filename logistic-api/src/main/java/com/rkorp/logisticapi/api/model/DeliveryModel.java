package com.rkorp.logisticapi.api.model;

import com.rkorp.logisticapi.domain.model.DeliveryStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class DeliveryModel {

    private Long id;
    private CustomerResumeModel customerResume;
    private RecipientModel recipient;
    private BigDecimal tax;
    private DeliveryStatus deliveryStatus;
    private OffsetDateTime requestDate;
    private OffsetDateTime deliveryDate;
}
