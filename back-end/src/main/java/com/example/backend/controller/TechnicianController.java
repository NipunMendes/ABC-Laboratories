package com.example.backend.controller;

import com.example.backend.exception.UserNotFoundException;
import com.example.backend.model.Technician;
import com.example.backend.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class TechnicianController {

    @Autowired
    private TechnicianRepository technicianRepo;

    @PostMapping("/LoginTechnician")
    public ResponseEntity<?>Login(@RequestBody Technician loginRequest){
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Technician technician = technicianRepo.findByUsername(username);

        if (technician == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        if (!password.equals(technician.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        return ResponseEntity.ok(technician.getTechnicianId());
    }

    @PostMapping("/RegisterTechnician")
    public ResponseEntity<Technician> newTechnician(@RequestBody Technician newTechnician){
        technicianRepo.save(newTechnician);
        return ResponseEntity.ok(newTechnician);
    }

    @GetMapping("/AllTechnician")
    List<Technician> getAllTechnician(){
        return technicianRepo.findAll();
    }

    @GetMapping("/Technician/{technicianId}")
    public Technician getTechnicianById(@PathVariable Integer technicianId){
        return technicianRepo.findById(technicianId)
                .orElseThrow(() -> new UserNotFoundException(technicianId));
    }
}
