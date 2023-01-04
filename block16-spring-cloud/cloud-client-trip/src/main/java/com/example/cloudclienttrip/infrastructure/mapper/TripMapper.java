package com.example.cloudclienttrip.infrastructure.mapper;

import com.example.cloudclienttrip.domain.entity.Trip;
import com.example.cloudclienttrip.infrastructure.controller.dto.TripDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TripMapper {

    TripDTO tripToTripDTO(Trip trip);

    Trip tripDtoToTrip(TripDTO tripDTO);

    List<TripDTO> map(List<Trip> listTrip);

}
