package com.vet.veterinary.expenses;

import com.vet.veterinary.models.Expense;
import com.vet.veterinary.models.Pet;
import com.vet.veterinary.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public String getServiceFeeDetails(long petId) {
        Pet pet = petRepository.findById(petId).get();
        List<Expense> expenses = pet.getExpenses();
        List<String> list = expenses.stream()
                .map(e -> e.serviceDetails + ": " + e.price + " NOK")
                .collect(Collectors.toList());
        list.add(getTotal(expenses));
        return list.toString();
    }

    public String getTotal(List<Expense> list) {
        int total = list.stream()
                .reduce(0, (subtotal, expense) ->
                        subtotal + expense.price, Integer::sum
                );
        return "Total (incl 25% MVA): " + total*1.25 + "  NOK";
    }
}
