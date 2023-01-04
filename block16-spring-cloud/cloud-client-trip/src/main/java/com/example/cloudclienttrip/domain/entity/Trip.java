package com.example.cloudclienttrip.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String origin;

    private String destination;

    private Date departureDate;

    private Date arrivalDate;

    @OneToMany
    private List<Client> listPassenger = new ArrayList<>();

    private String status;
}
