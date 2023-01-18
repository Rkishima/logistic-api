package com.rkorp.logisticapi.api.DTO;

import com.rkorp.logisticapi.domain.model.DeliveryStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class DeliveryDTO {

    private Long id;
    private CustomerResumeDTO customerResume;
    private RecipientDTO recipient;
    private BigDecimal tax;
    private DeliveryStatus deliveryStatus;
    private OffsetDateTime requestDate;
    private OffsetDateTime deliveryDate;
}
