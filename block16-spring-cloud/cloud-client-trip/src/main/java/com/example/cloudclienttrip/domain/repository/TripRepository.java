package com.example.cloudclienttrip.domain.repository;

import com.example.cloudclienttrip.domain.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

}
