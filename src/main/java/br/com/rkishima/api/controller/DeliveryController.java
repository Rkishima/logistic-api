package br.com.rkishima.api.controller;

import br.com.rkishima.domain.model.Delivery;
import br.com.rkishima.domain.service.SolicitationDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class DeliveryController {

    private SolicitationDeliveryService solicitationDeliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request(@Valid @RequestBody Delivery delivery){
        return solicitationDeliveryService.request(delivery);
    }
}
