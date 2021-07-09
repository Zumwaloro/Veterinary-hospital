package com.vet.veterinary.controllers;

import com.vet.veterinary.models.Pet;
import com.vet.veterinary.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/pet")
@CrossOrigin(origins = "*")
public class PetController {

    @Autowired
    private PetService service;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Pet> getAllPets() {
        return service.getAllPets();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Pet> getPetById(@PathVariable(value="id") long id) {
        return service.getPetById(id);
    }

    @PostMapping(value = "/post",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String postPetToDatabase(@RequestBody Pet pet) {
        return service.postPetToDatabase(pet);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deletePetFromDatabase(@PathVariable(value="id") long id) {
        return service.deletePetById(id);
    }

    @PutMapping(value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String updatePetInDatabase(@RequestBody Pet pet) {
        return service.updatePet(pet);
    }

}
