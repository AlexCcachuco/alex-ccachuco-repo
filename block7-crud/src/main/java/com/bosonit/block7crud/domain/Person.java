package com.bosonit.block7crud.domain;

import com.bosonit.block7crud.controller.dto.PersonInputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    int id;
    String name;
    String age;
    String town;

}
