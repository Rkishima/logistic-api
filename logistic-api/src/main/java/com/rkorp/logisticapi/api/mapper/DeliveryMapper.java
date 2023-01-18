package com.rkorp.logisticapi.api.mapper;

import com.rkorp.logisticapi.api.DTO.DeliveryDTO;
import com.rkorp.logisticapi.api.DTO.input.DeliveryInput;
import com.rkorp.logisticapi.domain.model.Delivery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DeliveryMapper {
    private ModelMapper modelMapper;

    public DeliveryDTO toModel(Delivery delivery){
        return modelMapper.map(delivery, DeliveryDTO.class);
    }

    public List<DeliveryDTO> toCollectionModel(List<Delivery> deliveries){
        return deliveries.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Delivery toEntity(DeliveryInput deliveryInput){
        return modelMapper.map(deliveryInput, Delivery.class);
    }
}
