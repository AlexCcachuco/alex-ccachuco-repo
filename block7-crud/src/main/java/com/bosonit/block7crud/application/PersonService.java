package com.bosonit.block7crud.application;

import com.bosonit.block7crud.domain.Person;
import com.bosonit.block7crud.repository.PersonRepository;

import java.util.List;

public interface PersonService {

    List<Person> findByName(String name);

}
