package com.vet.veterinary.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    @Column(columnDefinition = "TEXT")
    public String diagnosis;
    public String ownerName;
    public String ownerAddress;
    public long ownerPhone;
    @JsonManagedReference
    @OneToMany(
            mappedBy = "pet",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<Expense> expenses = new ArrayList<>();

    private Pet() {}

    public Pet(String name, String diagnosis, String ownerName, String ownerAddress, long ownerPhone) {
        this.name = name;
        this.diagnosis = diagnosis;
        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
        this.ownerPhone = ownerPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public long getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(long ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public void addExpense(Expense expense) { expenses.add(expense); }

    public void removeExpense(Expense expense) { expenses.remove(expense); }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
