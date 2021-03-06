package com.vet.veterinary.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    public String title;
    public String patientIds;

    private Staff() {}

    public Staff(String name, String title, String patientIds) {
        this.name = name;
        this.title = title;
        this.patientIds = patientIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPatientIds() { return patientIds; }

    public void setPatientIds(String patientIds) { this.patientIds = patientIds; }
}
