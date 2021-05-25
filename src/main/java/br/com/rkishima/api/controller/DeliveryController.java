package br.com.rkishima.api.controller;

import br.com.rkishima.api.mapper.DeliveryMapper;
import br.com.rkishima.api.model.DeliveryModel;
import br.com.rkishima.api.model.RecipientModel;
import br.com.rkishima.api.model.input.DeliveryInput;
import br.com.rkishima.domain.entities.Delivery;
import br.com.rkishima.domain.repository.DeliveryRepository;
import br.com.rkishima.domain.service.SolicitationDeliveryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class DeliveryController {

    private SolicitationDeliveryService solicitationDeliveryService;
    private DeliveryRepository deliveryRepository;
    private DeliveryMapper deliveryMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryModel request(@Valid @RequestBody DeliveryInput deliveryInput){
        Delivery newDelivery = deliveryMapper.toEntity(deliveryInput);
        Delivery requestDelivery = solicitationDeliveryService.request(newDelivery);
        return deliveryMapper.toModel(requestDelivery);

//        return deliveryMapper.toModel(solicitationDeliveryService.request(deliveryInput));
    }

    @GetMapping
    public List<DeliveryModel> findALl(){
        return deliveryMapper.toCollectionModel(deliveryRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<DeliveryModel> search(@PathVariable Long entregaId){
        return deliveryRepository.findById(entregaId)
                .map(delivery -> ResponseEntity.ok(deliveryMapper.toModel(delivery)))
                .orElse(ResponseEntity.notFound().build());
    }
}
