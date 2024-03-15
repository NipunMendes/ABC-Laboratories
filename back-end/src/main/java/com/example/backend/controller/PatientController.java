package com.example.backend.controller;

import com.example.backend.exception.UserNotFoundException;
import com.example.backend.model.Patient;
import com.example.backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class PatientController {

    @Autowired
    private PatientRepository PatientRepo;

    @PostMapping("/LoginPatient")
    public ResponseEntity<?> login(@RequestBody Patient loginRequest){
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Patient patient = PatientRepo.findByUsername(username);

        if (patient == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        if (!password.equals(patient.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        return ResponseEntity.ok(patient.getPatientId());
    }

    @PostMapping("/RegisterPatient")
    public ResponseEntity<Patient> newPatient(@RequestBody Patient newPatient){
        PatientRepo.save(newPatient);
        return ResponseEntity.ok(newPatient);
    }

    @GetMapping("/AllPatients")
    List<Patient> getAllPatients(){
        return PatientRepo.findAll();
    }

    @GetMapping("/Patient/{patientId}")
    public Patient getPatientById(@PathVariable Integer patientId){
        return PatientRepo.findById(patientId)
                .orElseThrow(()-> new UserNotFoundException(patientId));
    }

    @DeleteMapping("/Patient/{patientId}")
    public Patient deletePatientById(@PathVariable Integer patientId) {
        Patient patient = PatientRepo.findById(patientId)
                .orElseThrow(() -> new UserNotFoundException(patientId));
        PatientRepo.delete(patient);
        return patient;
    }
}
