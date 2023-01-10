package com.rkorp.logisticapi.domain.service;

import com.rkorp.logisticapi.domain.exception.BusinessException;
import com.rkorp.logisticapi.domain.model.Customer;
import com.rkorp.logisticapi.domain.model.Delivery;
import com.rkorp.logisticapi.domain.model.DeliveryStatus;
import com.rkorp.logisticapi.domain.repository.CustomerRepository;
import com.rkorp.logisticapi.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

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
        delivery.setRequestDate(LocalDateTime.now());
        return deliveryRepository.save(delivery);
    }
}
