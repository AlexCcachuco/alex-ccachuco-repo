package com.example.cloudclienttrip.application;


import com.example.cloudclienttrip.domain.entity.Client;

import java.util.List;

public interface ClienteService {

    void saveClient(Client client);
    void deleteClientById(int id);
    Client getClientById(int id);
    List<Client> getClients();
    Client updateClient(Client client, int id);
    int countPassengerFromTrip(int id);

}
