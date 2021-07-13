package com.vet.veterinary.services;

import com.vet.veterinary.expenses.ExpenseCalculator;
import com.vet.veterinary.models.Expense;
import com.vet.veterinary.models.Pet;
import com.vet.veterinary.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository repository;
    @Autowired
    ExpenseCalculator calculator;

    public Optional<Expense> getExpenseById(long id){
        return repository.findById(id);
    }

    public String postExpenseToDatabase(Expense expense) {
        repository.save(expense);
        return "Saved successfully!";
    }

    public String deleteExpenseById(long id) {
        repository.deleteById(id);
        return "Delete successful!";
    }

    public String updateExpense(Expense expense) {
        Expense expenseEntity;
        try {
            expenseEntity = repository.findById(expense.invoice).get();
        } catch (Exception e) { return "Failed to update."; }
        expenseEntity.price = expense.price;
        expenseEntity.serviceDetails = expense.serviceDetails;
        repository.save(expenseEntity);
        return "Update successful.";
    }

    public String calculateNewExpenses(long petId, String description, int cost) {
        return calculator.calculateNewExpenses(petId, description, cost);
    }

    public String getExpenseDetails(long petId) { return calculator.getServiceFeeDetails(petId); }


}
