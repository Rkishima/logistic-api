package br.com.rkishima.domain.service;

import br.com.rkishima.domain.exception.BusinessException;
import br.com.rkishima.domain.model.Cliente;
import br.com.rkishima.domain.model.Delivery;
import br.com.rkishima.domain.model.DeliveryStatus;
import br.com.rkishima.domain.repository.ClienteRepository;
import br.com.rkishima.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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
        delivery.setOrderDate(LocalDateTime.now());
        return deliveryRepository.save(delivery);
    }
}
