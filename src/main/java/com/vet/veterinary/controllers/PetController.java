package com.vet.veterinary.controllers;

import com.vet.veterinary.models.Pet;
import com.vet.veterinary.services.ExpenseService;
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
    private PetService petService;
    @Autowired
    private ExpenseService expenseService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Pet> getPetById(@PathVariable(value="id") long id) {
        return petService.getPetById(id);
    }

    @PostMapping(value = "/post",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String postPetToDatabase(@RequestBody Pet pet) {
        return petService.postPetToDatabase(pet);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deletePetFromDatabase(@PathVariable(value="id") long id) {
        return petService.deletePetById(id);
    }

    @PutMapping(value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String updatePetInDatabase(@RequestBody Pet pet) {
        return petService.updatePet(pet);
    }

    @RequestMapping(value = "/expenses/{petId}/{desc}/{cost}", method = RequestMethod.GET)
    public String addExpenseToPet(@PathVariable(value = "petId") long petId,
                                  @PathVariable(value = "desc") String desc,
                                  @PathVariable(value = "cost") int cost) {
        return expenseService.calculateNewExpenses(petId, desc, cost);
    }

    @RequestMapping(value = "/expenses/details/{id}", method = RequestMethod.GET)
    public String getExpenseDetails(@PathVariable(value = "id") long petId) {
        return expenseService.getExpenseDetails(petId);
    }

}
