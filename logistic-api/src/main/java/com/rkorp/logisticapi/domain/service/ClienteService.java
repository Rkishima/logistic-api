package com.rkorp.logisticapi.domain.service;

import com.rkorp.logisticapi.domain.exception.BusinessException;
import com.rkorp.logisticapi.domain.model.Cliente;
import com.rkorp.logisticapi.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente save(Cliente cliente){
        boolean existEmail = clienteRepository.findByEmail(cliente.getEmail()).stream()
                .anyMatch(clienteExistente -> clienteExistente.equals(cliente));
        if (existEmail){
            throw new BusinessException("Já existe um cliente cadastrado com este e-mail");
        }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void delete(Long id){
        clienteRepository.deleteById(id);
    }
}
