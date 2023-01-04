package com.example.cloudclienttrip.application;

import com.example.cloudclienttrip.domain.entity.Client;
import com.example.cloudclienttrip.domain.entity.Trip;
import com.example.cloudclienttrip.domain.repository.ClientRepository;
import com.example.cloudclienttrip.domain.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClienteService{

    @Autowired
    ClientRepository clientRepo;

    @Autowired
    TripRepository tripRepo;

    @Override
    public void saveClient(Client client) {
        clientRepo.save(client);
    }

    @Override
    public void deleteClientById(int id) {
        clientRepo.deleteById(id);
    }

    @Override
    public Client getClientById(int id) {
        return clientRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Client> getClients() {
        return clientRepo.findAll();
    }

    @Override
    public Client updateClient(Client client, int id) {
        Client clientDb = clientRepo.findById(id).orElseThrow();
        client.setId(clientDb.getId());
        return clientRepo.save(client);
    }

    @Override
    public int countPassengerFromTrip(int id) {
        Trip trip = tripRepo.findById(id).orElseThrow();
        return trip.getListPassenger().size();
    }


}
