package com.example.backend.controller;

import com.example.backend.exception.UserNotFoundException;
import com.example.backend.model.Appointment;
import com.example.backend.model.Availability;
import com.example.backend.model.Patient;
import com.example.backend.model.Technician;
import com.example.backend.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class AvailabilityController {

    @Autowired
    private AvailabilityRepository availabilityRepo;

    @PostMapping("/NewAvailability")
    public ResponseEntity<Availability> newAvailability(@RequestBody Availability newAvailability) {
        availabilityRepo.save(newAvailability);
        return ResponseEntity.ok(newAvailability);
    }

    @GetMapping("/Availability")
    List<Availability> getAllAvailability() {
        return availabilityRepo.findAll();
    }

    @GetMapping("/TechnicianAvailability/{technicianId}")
    public List<Availability> getAppointmentByPatientId(@PathVariable Integer technicianId) {
        return availabilityRepo.findAllByTechnicianId(technicianId);
    }

    @DeleteMapping("/TechnicianAvailability/{availabilityId}")
    public Availability deleteAvailabilityById(@PathVariable Integer availabilityId) {
        Availability availability = availabilityRepo.findById(availabilityId)
                .orElseThrow(() -> new UserNotFoundException(availabilityId));
        availabilityRepo.delete(availability);
        return availability;
    }

    @PutMapping("/Availability/{availabilityId}")
    public Availability updateAvailability(
            @PathVariable Integer availabilityId,
            @RequestBody Availability updatedAvailability
    ) {
        return availabilityRepo.findById(availabilityId)
                .map(availability -> {
                    availability.setDate(updatedAvailability.getDate());
                    availability.setTime(updatedAvailability.getTime());
                    availability.setAvailability(updatedAvailability.getAvailability());
                    return availabilityRepo.save(availability);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Availability with ID " + availabilityId + " not found"));
    }
}
