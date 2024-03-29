package com.example.backend.repository;

import com.example.backend.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository <Patient,Integer> {

    Patient findByUsername(String username);
}
