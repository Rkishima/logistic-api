package com.rkorp.logisticapi.api.model.input;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class DeliveryInput {

    @Valid
    @NotNull
    private ClienteIdInput cliente;

    @Valid
    @NotNull
    private RecipientInput recipient;

    @NotNull
    private BigDecimal tax;

}
