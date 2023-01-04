package com.example.cloudclienttrip.infrastructure.controller;

import com.example.cloudclienttrip.application.ClienteService;
import com.example.cloudclienttrip.domain.entity.Client;
import com.example.cloudclienttrip.infrastructure.controller.dto.ClientDTO;
import com.example.cloudclienttrip.infrastructure.mapper.ClientMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {

    @Autowired
    ClienteService clientService;

    ClientMapper mapper = Mappers.getMapper(ClientMapper.class);


    @PostMapping
    public ResponseEntity<?> createCliente(@RequestBody ClientDTO clienteDTO){
        Client client = mapper.clientDtoToClient(clienteDTO);
        clientService.saveClient(client);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        clientService.deleteClientById(id);
        return ResponseEntity.ok().body("Client with id : "+ id +" deleted correctly");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
       Client client =  clientService.getClientById(id);
       return ResponseEntity.ok(mapper.clientToClientDTO(client));
    }

    @GetMapping("/getAll")
    public List<ClientDTO> getAllClients(){
        return mapper.map(clientService.getClients());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@RequestBody ClientDTO clientDTO, @PathVariable int id){
        Client client = mapper.clientDtoToClient(clientDTO);
        return ResponseEntity.ok(clientService.updateClient(client, id));
    }

    @GetMapping("/count/{tripId}")
    public  ResponseEntity<?> countPassengerFromTrip(@PathVariable int tripId){
        int numberPassenger = clientService.countPassengerFromTrip(tripId);
        return ResponseEntity.ok("Trip with id: "+ tripId + " Has : "+ numberPassenger +" passengers " );
    }

}
