package com.example.backend.repository;

import com.example.backend.model.TechAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechAvailabilityRepository extends JpaRepository<TechAvailability,Integer> {

    List<TechAvailability> findAllByTechnicianId(Integer technicianId);
}
