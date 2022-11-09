package com.rkorp.logisticapi.api.controller;

import com.rkorp.logisticapi.com.rkorp.logisticapi.domain.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired

    @GetMapping("/listar")
    public String listar(){
        return "teste";
    }

    @PostMapping("/cliente")
    public Cliente saveClient(Cliente cliente){
        return cliente;
    }

}
