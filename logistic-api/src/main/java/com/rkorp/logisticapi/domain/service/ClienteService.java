package com.rkorp.logisticapi.domain.service;

import com.rkorp.logisticapi.domain.exception.BusinessException;
import com.rkorp.logisticapi.domain.model.Customer;
import com.rkorp.logisticapi.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Customer save(Customer customer){
        boolean existEmail = clienteRepository.findByEmail(customer.getEmail()).stream()
                .anyMatch(existingCustomer -> existingCustomer.equals(customer));
        if (existEmail){
            throw new BusinessException("Já existe um cliente cadastrado com este e-mail");
        }
        return clienteRepository.save(customer);
    }

    @Transactional
    public void delete(Long id){
        clienteRepository.deleteById(id);
    }
}
