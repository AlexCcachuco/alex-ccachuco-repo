package com.example.cloudticket.infrastructure.controller;

import com.example.cloudticket.application.TicketService;
import com.example.cloudticket.domain.entity.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;


    @PostMapping("/generateTicket/{clientId}/{tripId}")
    public Ticket createTicket(@PathVariable(name = "clientId") int clientId, @PathVariable(name = "tripId") int tripId){
        return ticketService.generateTicket(clientId, tripId);
    }

}
