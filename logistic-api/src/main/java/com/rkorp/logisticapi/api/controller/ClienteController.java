package com.rkorp.logisticapi.api.controller;

import com.rkorp.logisticapi.domain.model.Customer;
import com.rkorp.logisticapi.domain.repository.ClienteRepository;
import com.rkorp.logisticapi.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;


    @GetMapping()
    public List<Customer> findAll() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveClient(@Valid @RequestBody Customer customer) {
        return clienteService.save(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateClient(Long id, @Valid @RequestBody Customer customer) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        customer.setId(id);
        customer = clienteService.save(customer);

        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
