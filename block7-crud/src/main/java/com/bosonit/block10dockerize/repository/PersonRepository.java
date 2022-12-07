package com.bosonit.block10dockerize.repository;

import com.bosonit.block10dockerize.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByName(String name);

}
