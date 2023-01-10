package com.rkorp.logisticapi.api.controller;

import com.rkorp.logisticapi.domain.model.Delivery;
import com.rkorp.logisticapi.domain.service.RequestDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private RequestDeliveryService requestDeliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request(@RequestBody Delivery delivery){
        return requestDeliveryService.request(delivery);
    }
}
