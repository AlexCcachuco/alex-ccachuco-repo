package com.example.cloudticket.application;

import com.example.cloudticket.domain.entity.Client;
import com.example.cloudticket.domain.entity.Ticket;
import com.example.cloudticket.domain.entity.Trip;
import com.example.cloudticket.domain.repository.TicketRepository;
import com.example.cloudticket.infrastructure.controller.feign.TripClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    TripClientService feignService;
    @Autowired
    TicketRepository ticketRepo;


    @Override
    public Ticket generateTicket(int idClient, int idTrip) {
        Client client = feignService.getClientById(idClient);
        Trip trip = feignService.getTripById(idTrip);

        Ticket ticket = new Ticket();
        ticket.setPassengerId(client.getId());
        ticket.setPassengerName(client.getName());
        ticket.setPassengerLastname(client.getSurname());
        ticket.setPassengerEmail(client.getEmail());
        ticket.setTripOrigin(trip.getOrigin());
        ticket.setTripDestination(trip.getDestination());
        ticket.setDepartureDate(trip.getDepartureDate());
        ticket.setArrivalDate(trip.getArrivalDate());

        return ticketRepo.save(ticket);
    }
}
