package com.rkorp.logisticapi.api.controller;

import com.rkorp.logisticapi.api.DTO.OccurrenceDTO;
import com.rkorp.logisticapi.api.DTO.input.OccurrenceInput;
import com.rkorp.logisticapi.api.mapper.OccurrenceMapper;
import com.rkorp.logisticapi.domain.model.Delivery;
import com.rkorp.logisticapi.domain.model.Occurrence;
import com.rkorp.logisticapi.domain.service.OccurrenceRegistrationService;
import com.rkorp.logisticapi.domain.service.SearchDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery/{deliveryId}/occurrences")
public class OccurrenceController {

    private OccurrenceRegistrationService occurrenceRegistrationService;
    private SearchDeliveryService searchDeliveryService;
    private OccurrenceMapper occurrenceMapper;

    public OccurrenceDTO register(@PathVariable Long deliveryId, @Valid @RequestBody OccurrenceInput occurrenceInput) {
        Occurrence registerOccurrrence = occurrenceRegistrationService.register(deliveryId, occurrenceInput.getDescription());

        return occurrenceMapper.toModel(registerOccurrrence);
    }

    public List<OccurrenceDTO> listOccurrence(@PathVariable Long deliveryId) {
        Delivery delivery = searchDeliveryService.search(deliveryId);

        return occurrenceMapper.toCollectionModel(delivery.getOccurrenceList());
    }
}
