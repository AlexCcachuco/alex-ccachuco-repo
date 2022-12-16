package com.bosonit.block13mongodb.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private String id;
    private String username;
    private String name;
    private String surname;
    private int age;
    private String email;
}
