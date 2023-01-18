package com.rkorp.logisticapi.domain.service;

import com.rkorp.logisticapi.domain.exception.BusinessException;
import com.rkorp.logisticapi.domain.model.Delivery;
import com.rkorp.logisticapi.domain.model.Occurrence;
import com.rkorp.logisticapi.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class OccurrenceRegistrationService {

    private SearchDeliveryService searchDeliveryService;

    @Transactional
    public Occurrence register(Long deliveryId, String description) {
        Delivery delivery = searchDeliveryService.search(deliveryId);

        return delivery.addOccurrence(description);
    }
}
