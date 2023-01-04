package com.example.cloudticket.domain.entity;

import lombok.Data;

@Data
public class Client {

    private int id;

    private String name;

    private String surname;

    private int age;

    private String email;

    private String phone;
}
