package br.com.rkishima.domain.service;

import br.com.rkishima.domain.exception.BusinessException;
import br.com.rkishima.domain.entities.Cliente;
import br.com.rkishima.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public Cliente search(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Cliente não encontrado"));
    }

    @Transactional
    public Cliente save(Cliente cliente){
        boolean existEmail = clienteRepository.findByEmail(cliente.getEmail())
                .stream().anyMatch(existCliente -> !existCliente.equals(cliente));
        //Aqui diz: Se o cliente que encontrou na no repositório for diferente do cliente
        // que estamos salvando, então da "match", então da "true"
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
