package com.rkorp.logisticapi.api.controller;

import com.rkorp.logisticapi.api.mapper.DeliveryMapper;
import com.rkorp.logisticapi.api.DTO.DeliveryDTO;
import com.rkorp.logisticapi.api.DTO.input.DeliveryInput;
import com.rkorp.logisticapi.domain.model.Delivery;
import com.rkorp.logisticapi.domain.service.RequestDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private RequestDeliveryService requestDeliveryService;
    private DeliveryMapper deliveryMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryDTO request(@Valid @RequestBody DeliveryInput deliveryInput) {
        Delivery newDelivery = deliveryMapper.toEntity(deliveryInput);
        Delivery requestDelivery = requestDeliveryService.request(newDelivery);
        return deliveryMapper.toModel(requestDeliveryService.request(requestDelivery));
    }

    @GetMapping
    public List<DeliveryDTO> findAll() {
        return deliveryMapper.toCollectionModel(requestDeliveryService.findAll());
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryDTO> findById(@PathVariable Long deliveryId) {
        return requestDeliveryService.findById(deliveryId)
                .map(delivery -> ResponseEntity.ok(deliveryMapper.toModel(delivery))).orElseThrow();
    }
}
