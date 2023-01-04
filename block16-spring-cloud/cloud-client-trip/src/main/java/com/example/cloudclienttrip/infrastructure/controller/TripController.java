package com.example.cloudclienttrip.infrastructure.controller;

import com.example.cloudclienttrip.application.ClienteService;
import com.example.cloudclienttrip.application.TripService;
import com.example.cloudclienttrip.domain.entity.Client;
import com.example.cloudclienttrip.domain.entity.Trip;
import com.example.cloudclienttrip.domain.exception.ElementLimitException;
import com.example.cloudclienttrip.domain.exception.ElementNotFoundException;
import com.example.cloudclienttrip.infrastructure.controller.dto.ClientDTO;
import com.example.cloudclienttrip.infrastructure.controller.dto.TripDTO;
import com.example.cloudclienttrip.infrastructure.mapper.TripMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    TripService tripService;

    TripMapper mapper = Mappers.getMapper(TripMapper.class);


    @PostMapping
    public ResponseEntity<?> createTrip(@RequestBody TripDTO tripDTO){

        Trip trip = mapper.tripDtoToTrip(tripDTO);
        tripService.saveTrip(trip);
        return ResponseEntity.ok(trip);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) throws ElementNotFoundException {
        tripService.deleteTripById(id);
        return ResponseEntity.ok().body("Trip with id : "+ id +" deleted correctly");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) throws ElementNotFoundException {
        Trip trip = tripService.getTripById(id);
        return ResponseEntity.ok(mapper.tripToTripDTO(trip));
    }

    @GetMapping("/getAll")
    public List<TripDTO> getAllTrips(){
        return mapper.map(tripService.getTrips());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTrip(@RequestBody TripDTO tripDTO, @PathVariable int id) throws ElementNotFoundException {
        Trip trip = mapper.tripDtoToTrip(tripDTO);
        return ResponseEntity.ok(tripService.updateTrip(trip, id));
    }

    @PostMapping("/addPassenger")
    public ResponseEntity<?> addPassenger(@RequestParam int idTrip, @RequestParam int idClient) {
        try{
            return ResponseEntity.ok(tripService.addPassengerToTrip(idTrip, idClient));
        }  catch (ElementLimitException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Maximum passenger limit reached");
        } catch (ElementNotFoundException a){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entity not found");
        }
    }

    @PutMapping
    public ResponseEntity<?> changeStatus(@RequestParam int idTrip, @RequestParam String status) throws ElementNotFoundException {
        return ResponseEntity.ok(tripService.updateTripStatus(idTrip, status));
    }

    @GetMapping("/verify/{id}")
    public ResponseEntity<?> verifyStatus(@PathVariable int id) throws ElementNotFoundException {
        return ResponseEntity.ok("Trip with id - "+ id + " - status: "+ tripService.verifyStatus(id));
    }
}
