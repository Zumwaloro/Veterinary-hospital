package com.vet.veterinary.services;

import com.vet.veterinary.models.Pet;
import com.vet.veterinary.models.Staff;
import com.vet.veterinary.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class StaffService {

    @Autowired
    StaffRepository repository;

    public String getAllPatientIds(long id) {
        try {
            return  repository.findById(id).get().patientIds;
        } catch (Exception e) {
            return "No patients to be found.";
        }
    }

    public Optional<Staff> getStaffMember(long id) {
        return repository.findById(id);
    }

    public String postStaffToDatabase(Staff staff) {
        repository.save(staff);
        return staff.name + " was saved successfully.";
    }

    public String deleteStaffById(long id) {
        repository.deleteById(id);
        return "Delete successful!";
    }

    public String updateStaff(Staff staff) {
        Staff staffEntity;
        try {
            staffEntity = repository.findById(staff.id).get();
        } catch (Exception e) { return "Failed to update."; }
        staffEntity.name = staff.name;
        staffEntity.title = staff.title;
        staffEntity.patientIds = staff.getPatientIds();
        repository.save(staffEntity);
        return "Update successful.";
    }

}
