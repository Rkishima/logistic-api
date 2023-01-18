package com.rkorp.logisticapi.domain.service;

import com.rkorp.logisticapi.domain.exception.BusinessException;
import com.rkorp.logisticapi.domain.exception.NotFoundEntityException;
import com.rkorp.logisticapi.domain.model.Delivery;
import com.rkorp.logisticapi.domain.model.Occurrence;
import com.rkorp.logisticapi.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SearchDeliveryService {
    private DeliveryRepository deliveryRepository;

    public Delivery search(Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new NotFoundEntityException("Entrega não encontrada"));
    }
}
