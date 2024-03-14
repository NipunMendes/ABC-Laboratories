package com.example.backend.repository;

import com.example.backend.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository <Doctor,Integer> {
    Doctor findByUsername(String username);
}
