package com.vet.veterinary.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long invoice;
    public int price;
    public String serviceDetails;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "pet_id")
    public Pet pet;

    private Expense() {}

    public Expense(int price, String serviceDetails, Pet pet) {
        this.price = price;
        this.serviceDetails = serviceDetails;
        this.pet = pet;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(String serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
