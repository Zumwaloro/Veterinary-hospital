package com.vet.veterinary.repositories;

import com.vet.veterinary.models.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
}
