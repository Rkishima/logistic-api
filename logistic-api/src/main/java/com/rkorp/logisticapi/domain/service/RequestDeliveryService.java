package com.rkorp.logisticapi.domain.service;

import com.rkorp.logisticapi.domain.model.Customer;
import com.rkorp.logisticapi.domain.model.Delivery;
import com.rkorp.logisticapi.domain.model.DeliveryStatus;
import com.rkorp.logisticapi.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RequestDeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;
    private CustomerService customerService;
    @Transactional
    public Delivery request(Delivery delivery){
        Customer customer = customerService.search(delivery.getCustomer().getId());

        delivery.setCustomer(customer);
        delivery.setStatus(DeliveryStatus.PENDING);
        delivery.setRequestDate(OffsetDateTime.now());
        return deliveryRepository.save(delivery);
    }

    public List<Delivery> findAll(){
        return deliveryRepository.findAll();
    }

    public Optional<Delivery> findById(@PathVariable Long deliveryId){
        return deliveryRepository.findById(deliveryId);
    }
}
