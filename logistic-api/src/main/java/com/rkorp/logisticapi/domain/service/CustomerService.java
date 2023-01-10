package com.rkorp.logisticapi.domain.service;

import com.rkorp.logisticapi.domain.exception.BusinessException;
import com.rkorp.logisticapi.domain.model.Customer;
import com.rkorp.logisticapi.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Customer save(Customer customer){
        boolean existEmail = customerRepository.findByEmail(customer.getEmail()).stream()
                .anyMatch(existingCustomer -> existingCustomer.equals(customer));
        if (existEmail){
            throw new BusinessException("Já existe um cliente cadastrado com este e-mail");
        }
        return customerRepository.save(customer);
    }

    @Transactional
    public void delete(Long id){
        customerRepository.deleteById(id);
    }
}
