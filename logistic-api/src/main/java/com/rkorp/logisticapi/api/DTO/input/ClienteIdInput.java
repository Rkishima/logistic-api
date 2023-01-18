package com.rkorp.logisticapi.api.DTO.input;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ClienteIdInput {
    @NotNull
    private Long id;
}
