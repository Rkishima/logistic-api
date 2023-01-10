package com.rkorp.logisticapi.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private DeliveryStatus status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime requestDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime deliveryDate;

}
