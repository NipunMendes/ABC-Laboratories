package com.example.backend.repository;

import com.example.backend.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepository extends JpaRepository <Technician,Integer> {
    Technician findByUsername(String username);
}
