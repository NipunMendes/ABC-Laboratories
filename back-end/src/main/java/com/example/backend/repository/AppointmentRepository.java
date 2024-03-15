package com.example.backend.repository;

import com.example.backend.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository <Appointment,Integer>{
    List<Appointment> findAllByPatientId(Integer patientId);

    List<Appointment> findAllByDoctorId(Integer doctorId);

    List<Appointment> findAllByDoctorIdAndStatus(Integer doctorId, String status);

    List<Appointment> findAllByTechnicianId(Integer technicianId);

    List<Appointment> findAllByTechnicianIdAndStatus(Integer technicianId, String status);

    List<Appointment> findAllByStatus(String status);
}
