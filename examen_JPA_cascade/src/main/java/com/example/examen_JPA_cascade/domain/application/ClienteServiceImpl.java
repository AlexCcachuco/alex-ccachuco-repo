package com.example.examen_JPA_cascade.domain.application;

import com.example.examen_JPA_cascade.domain.Cliente;
import com.example.examen_JPA_cascade.respository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepo;

    public void addCliente(Cliente cliente){
        clienteRepo.save(cliente);
    }

}
