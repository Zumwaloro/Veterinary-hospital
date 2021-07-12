package com.vet.veterinary.models;

import javax.persistence.*;

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
    public int treatmentCostsDue;
    public int treatmentCostsPaid;

    private Pet() {}

    public Pet(String name, String diagnosis, String ownerName, String ownerAddress, long ownerPhone, int treatmentCostsDue, int treatmentCostsPaid) {
        this.name = name;
        this.diagnosis = diagnosis;
        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
        this.ownerPhone = ownerPhone;
        this.treatmentCostsDue = treatmentCostsDue;
        this.treatmentCostsPaid = treatmentCostsPaid;
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

    public int getTreatmentCostsDue() {
        return treatmentCostsDue;
    }

    public void setTreatmentCostsDue(int treatmentCostsDue) {
        this.treatmentCostsDue = treatmentCostsDue;
    }

    public int getTreatmentCostsPaid() {
        return treatmentCostsPaid;
    }

    public void setTreatmentCostsPaid(int treatmentCostsPaid) {
        this.treatmentCostsPaid = treatmentCostsPaid;
    }
}
