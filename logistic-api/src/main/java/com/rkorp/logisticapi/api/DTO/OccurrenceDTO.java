package com.rkorp.logisticapi.api.DTO;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class OccurrenceDTO {
    private Long id;
    private String description;
    private OffsetDateTime registrationDate;
}
