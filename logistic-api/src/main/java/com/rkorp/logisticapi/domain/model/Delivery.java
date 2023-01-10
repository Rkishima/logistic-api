package com.rkorp.logisticapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Customer customer;

    @Embedded
    private Recipient recipient;

    private BigDecimal tax;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    private LocalDateTime requestDate;
    private LocalDateTime deliveryDate;

}
