package com.vet.veterinary.repositories;

import com.vet.veterinary.models.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PetRepository extends CrudRepository<Pet, Long> {

    Optional<Pet> findByName(String name);
}
