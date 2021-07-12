package com.vet.veterinary.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    //public Pet pet;
    public String address;
    public long phone;
    public int treatmentCostsDue;
    public int getTreatmentCostsPaid;

    private Owner() {}

    public Owner(String name, String address, long phone, int treatmentCostsDue, int getTreatmentCostsPaid) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.treatmentCostsDue = treatmentCostsDue;
        this.getTreatmentCostsPaid = getTreatmentCostsPaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getTreatmentCostsDue() {
        return treatmentCostsDue;
    }

    public void setTreatmentCostsDue(int treatmentCostsDue) {
        this.treatmentCostsDue = treatmentCostsDue;
    }

    public int getGetTreatmentCostsPaid() {
        return getTreatmentCostsPaid;
    }

    public void setGetTreatmentCostsPaid(int getTreatmentCostsPaid) {
        this.getTreatmentCostsPaid = getTreatmentCostsPaid;
    }
}
