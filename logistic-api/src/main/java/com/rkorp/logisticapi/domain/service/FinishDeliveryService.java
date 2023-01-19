package com.rkorp.logisticapi.domain.service;

import com.rkorp.logisticapi.domain.model.Delivery;
import com.rkorp.logisticapi.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinishDeliveryService {

    private SearchDeliveryService searchDeliveryService;
    private DeliveryRepository deliveryRepository;

    @Transactional
    public void finishDelivery(Long deliveryId){
        Delivery delivery = searchDeliveryService.search(deliveryId);
        delivery.finish();
        deliveryRepository.save(delivery);
    }
}
