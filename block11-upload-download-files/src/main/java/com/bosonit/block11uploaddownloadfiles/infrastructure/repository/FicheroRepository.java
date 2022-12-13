package com.bosonit.block11uploaddownloadfiles.infrastructure.repository;

import com.bosonit.block11uploaddownloadfiles.domain.Fichero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FicheroRepository extends JpaRepository<Fichero, Integer> {

    Optional<Fichero> findByName(String name);

}
