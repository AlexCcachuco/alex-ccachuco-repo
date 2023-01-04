package com.example.cloudclienttrip.infrastructure.controller.dto;

import com.example.cloudclienttrip.domain.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripDTO {


    private int id;

    private String origin;

    private String destination;

    private Date departureDate;

    private Date arrivalDate;

    private List<ClientDTO> listPassenger = new ArrayList<>();

    private String status;

}
