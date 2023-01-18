package com.rkorp.logisticapi.api.DTO.input;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

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
