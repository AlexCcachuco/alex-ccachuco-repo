package com.example.cloudticket.application;

import com.example.cloudticket.domain.entity.Ticket;

public interface TicketService {

    Ticket generateTicket(int idClient, int idTrip);

}
