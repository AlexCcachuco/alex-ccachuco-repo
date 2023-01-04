package com.example.cloudclienttrip.infrastructure.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

     int id;
     String name;
     String surname;
     int age;
     String email;
     String phone;

}
