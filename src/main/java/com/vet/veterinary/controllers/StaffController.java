package com.vet.veterinary.controllers;

import com.vet.veterinary.models.Staff;
import com.vet.veterinary.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/staff")
@CrossOrigin(origins = "*")
public class StaffController {

    @Autowired
    StaffService staffService;

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
    public String getAllPatientIds(@PathVariable(value="id") long id) {
        return staffService.getAllPatientIds(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Staff> getStaffMember(@PathVariable(value = "id") long id) {
        return staffService.getStaffMember(id);
    }

    @PostMapping(value = "/post",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String postStaffToDatabase(@RequestBody Staff staff) {
        return staffService.postStaffToDatabase(staff);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteStaffFromDatabase(@PathVariable(value = "id") long id) {
        return staffService.deleteStaffById(id);
    }

    @PutMapping(value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String updateStaff(@RequestBody Staff staff) {
        return staffService.updateStaff(staff);
    }
}
