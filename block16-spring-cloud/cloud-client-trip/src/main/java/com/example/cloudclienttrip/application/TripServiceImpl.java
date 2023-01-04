package com.example.cloudclienttrip.application;

import com.example.cloudclienttrip.domain.entity.Client;
import com.example.cloudclienttrip.domain.entity.Trip;
import com.example.cloudclienttrip.domain.exception.ElementLimitException;
import com.example.cloudclienttrip.domain.exception.ElementNotFoundException;
import com.example.cloudclienttrip.domain.repository.ClientRepository;
import com.example.cloudclienttrip.domain.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepo;

    @Autowired
    private ClientRepository clientRepo;

    @Override
    public void saveTrip(Trip trip) {
        tripRepo.save(trip);
    }

    @Override
    public void deleteTripById(int id) throws ElementNotFoundException {
        tripRepo.findById(id).orElseThrow(()-> new ElementNotFoundException("Trip with id : "+ id + " Not found"));
        tripRepo.deleteById(id);
    }

    @Override
    public Trip getTripById(int id) throws ElementNotFoundException {
        return tripRepo.findById(id).orElseThrow(()-> new ElementNotFoundException("Trip with id : "+ id + " Not found"));
    }

    @Override
    public List<Trip> getTrips() {
        return tripRepo.findAll();
    }

    @Override
    public Trip updateTrip(Trip trip, int id) throws ElementNotFoundException {
        Trip tripDb = tripRepo.findById(id).orElseThrow(()-> new ElementNotFoundException("Trip with id : "+ id + " Not found"));
        trip.setId(tripDb.getId());
        return tripRepo.save(trip);
    }

    @Override
    public Trip addPassengerToTrip(int idTrip, int idClient) throws ElementLimitException, ElementNotFoundException {
        Trip trip = tripRepo.findById(idTrip).orElseThrow(()-> new ElementNotFoundException("Trip with id : "+ idTrip + " Not found"));
        Client client = clientRepo.findById(idClient).orElseThrow();
        int numberPassenger = trip.getListPassenger().size();
        if(numberPassenger >= 40){
            throw new ElementLimitException("Maximum passenger limit reached");
        }
        trip.getListPassenger().add(client);
        return tripRepo.save(trip);
    }

    @Override
    public Trip updateTripStatus(int idTrip, String status) throws ElementNotFoundException {
        Trip trip = tripRepo.findById(idTrip).orElseThrow(()-> new ElementNotFoundException("Trip with id : "+ idTrip + " Not found"));
        if(status.equals("ON") || status.equals("OFF")) {
            trip.setStatus(status);
            tripRepo.save(trip);
            return trip;
        }
        return null;
    }

    @Override
    public String verifyStatus(int id) throws ElementNotFoundException {
        Trip trip = tripRepo.findById(id).orElseThrow(()-> new ElementNotFoundException("Trip with id : "+ id + " Not found"));
        return trip.getStatus();
    }


}
