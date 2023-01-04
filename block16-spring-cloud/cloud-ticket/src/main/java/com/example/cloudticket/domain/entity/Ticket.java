package com.example.cloudticket.domain.entity;




//import jakarta.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int passengerId;

    private String passengerName;

    private String passengerLastname;

    private String passengerEmail;

    private String tripOrigin;

    private String tripDestination;

    private Date departureDate;

    private Date arrivalDate;

}
