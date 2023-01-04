package com.example.cloudticket.domain.entity;

//import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Trip {

    private int id;

    private String origin;

    private String destination;

    private Date departureDate;

    private Date arrivalDate;

    private List<Client> listPassenger = new ArrayList<>();

    private String status;

}
