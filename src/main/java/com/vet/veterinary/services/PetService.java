package com.vet.veterinary.services;

import com.vet.veterinary.models.Pet;
import com.vet.veterinary.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    public Iterable<Pet> getAllPets(){
        return petRepository.findAll();
    }

    //Get pet by id
    public Optional<Pet> getPetById(long id){
        return petRepository.findById(id);
    }

    //Get pet by name
    public Optional<Pet> getPetByName(String name) {
        return petRepository.findByName(name);
    }

    //Post Pet to database
    public String postPetToDatabase(Pet pet) {
        petRepository.save(pet);
        return "Saved successfully!";
    }

    //Delete Pet by id
    public String deletePetById(long id) {
        petRepository.deleteById(id);
        return "Delete successful!";
    }

    //Update Pet in database
    public String updatePet(Pet pet) {
        Pet petEntity;
        try {
            petEntity = petRepository.findById(pet.id).get();
        } catch (Exception e) { return "Failed to update."; }
        petEntity.name = pet.name;
        petEntity.diagnosis = pet.diagnosis;
        petEntity.ownerName = pet.ownerName;
        petEntity.ownerAddress = pet.ownerAddress;
        petEntity.ownerPhone = pet.ownerPhone;
        petRepository.save(petEntity);
        return "Update successful.";
    }


}
