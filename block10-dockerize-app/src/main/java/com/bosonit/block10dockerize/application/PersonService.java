package com.bosonit.block10dockerize.application;

import com.bosonit.block10dockerize.domain.Person;

import java.util.List;

public interface PersonService {

    List<Person> findByName(String name);

}
