package com.example.backend.controller;

import com.example.backend.model.TechAvailability;
import com.example.backend.repository.TechAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class TechAvailabilityController {

    @Autowired
    private TechAvailabilityRepository techAvailabilityRepo;

    @PostMapping("/NewTechAvailability")
    public ResponseEntity<TechAvailability> newTechAvailability(@RequestBody TechAvailability newTechAvailability){
        techAvailabilityRepo.save(newTechAvailability);
        return ResponseEntity.ok(newTechAvailability);
    }

    @GetMapping("/TechAvailability")
    List<TechAvailability> getAllAvailability(){
        return techAvailabilityRepo.findAll();
    }

    @GetMapping("/TechAvailability/{technicianId}")
    public List<TechAvailability> getAppointmentByPatientId(@PathVariable Integer technicianId){
        return techAvailabilityRepo.findAllByTechnicianId(technicianId);
    }
}
