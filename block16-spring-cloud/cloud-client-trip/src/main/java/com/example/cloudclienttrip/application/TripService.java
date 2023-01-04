package com.example.cloudclienttrip.application;


import com.example.cloudclienttrip.domain.entity.Client;
import com.example.cloudclienttrip.domain.entity.Trip;
import com.example.cloudclienttrip.domain.exception.ElementLimitException;
import com.example.cloudclienttrip.domain.exception.ElementNotFoundException;

import java.util.List;

public interface TripService {

    void saveTrip(Trip trip);
    void deleteTripById(int id) throws ElementNotFoundException;
    Trip getTripById(int id) throws ElementNotFoundException;
    List<Trip> getTrips();
    Trip updateTrip(Trip trip, int id) throws ElementNotFoundException;
    Trip addPassengerToTrip(int idTrip, int idclient) throws ElementLimitException, ElementNotFoundException;
    Trip updateTripStatus(int idTrip, String status) throws ElementNotFoundException;
    String verifyStatus(int id) throws ElementNotFoundException;
}
