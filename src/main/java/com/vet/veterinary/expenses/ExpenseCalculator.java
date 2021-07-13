package com.vet.veterinary.expenses;

import com.vet.veterinary.models.Expense;
import com.vet.veterinary.models.Pet;
import com.vet.veterinary.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExpenseCalculator {

    @Autowired
    PetRepository petRepository;

    public String calculateNewExpenses(long petId, String description, int cost) {
        Pet pet = petRepository.findById(petId).get();
        Expense expense = new Expense(cost, description, pet);
        pet.addExpense(expense);
        petRepository.save(pet);
        return "Expense added.";
    }

    public String getServiceFeeDetails(Pet pet) {
        return pet.getExpenses().stream()
                .map(e -> e.serviceDetails + ": " + e.price)
                .toString();
    }
}
