package com.example.backend.controller;

import com.example.backend.exception.UserNotFoundException;
import com.example.backend.model.Doctor;
import com.example.backend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepo;

    @PostMapping("/LoginDoctor")
    public ResponseEntity<?>Login(@RequestBody Doctor loginRequest){
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Doctor doctor = doctorRepo.findByUsername(username);

        if (doctor == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        if (!password.equals(doctor.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        return ResponseEntity.ok(doctor.getDoctorId());
    }

    @PostMapping("/RegisterDoctor")
    public ResponseEntity<Doctor> newDoctor(@RequestBody Doctor newDoctor){
        doctorRepo.save(newDoctor);
        return ResponseEntity.ok(newDoctor);
    }

    @GetMapping("/AllDoctor")
    List<Doctor> getAllDoctor(){
        return doctorRepo.findAll();
    }

    @GetMapping("/Doctor/{doctorId}")
    public Doctor getDoctorById(@PathVariable Integer doctorId){
        return doctorRepo.findById(doctorId)
                .orElseThrow(() -> new UserNotFoundException(doctorId));
    }

    @DeleteMapping("/Doctor/{doctorId}")
    public Doctor deleteDoctorById(@PathVariable Integer doctorId) {
        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new UserNotFoundException(doctorId));
        doctorRepo.delete(doctor);
        return doctor;
    }
}
