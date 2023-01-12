package com.rkorp.logisticapi.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rkorp.logisticapi.domain.ValidationGroups;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Valid
    @NotNull
    @ManyToOne
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
    private Customer customer;

    @Embedded
    @NotNull
    @Valid
    private Recipient recipient;

    @NotNull
    private BigDecimal tax;

    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private DeliveryStatus status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime requestDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime deliveryDate;

}
