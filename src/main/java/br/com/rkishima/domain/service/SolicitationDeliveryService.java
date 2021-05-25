package br.com.rkishima.domain.service;

import br.com.rkishima.domain.entities.Cliente;
import br.com.rkishima.domain.entities.Delivery;
import br.com.rkishima.domain.entities.DeliveryStatus;
import br.com.rkishima.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class SolicitationDeliveryService {

    private DeliveryRepository deliveryRepository;
    private ClienteService clienteService;

    @Transactional
    public Delivery request(Delivery delivery){

        Cliente cliente = clienteService.search(delivery.getCliente().getId());

        delivery.setCliente(cliente); //Isso é para não trazer como resposta apenas o ID preenchido
        delivery.setStatus(DeliveryStatus.PENDENTE);
        delivery.setOrderDate(OffsetDateTime.now());
        return deliveryRepository.save(delivery);
    }
}
