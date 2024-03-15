package com.example.backend.controller;

import com.example.backend.exception.UserNotFoundException;
import com.example.backend.model.Appointment;
import com.example.backend.repository.AppointmentRepository;
import com.example.backend.repository.PatientRepository;
import com.example.backend.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class TechAppointmentController {

    @Autowired
    private AppointmentRepository AppointmentRepo;
    private PatientRepository PatientRepo;
    private TechnicianRepository technicianRepo;

    @PostMapping("/TechMakeAppointment")
    public ResponseEntity<Appointment> newAppointment(@RequestBody Appointment newAppointment){
        AppointmentRepo.save(newAppointment);
        return ResponseEntity.ok(newAppointment);
    }

    @GetMapping("/TechAppointments")
    public List<Appointment> getAppointments(){
        return AppointmentRepo.findAll();
    }

    @GetMapping("/TechAppointments/{status}")
    public List<Appointment> getAppointmentsByStatus(@PathVariable String status){
        return AppointmentRepo.findAllByStatus(status);
    }

    @GetMapping("/PatientTechAppointments/{patientId}")
    public List<Appointment> getAppointmentByPatientId(@PathVariable Integer patientId){
        return AppointmentRepo.findAllByPatientId(patientId);
    }

    @GetMapping("/TechnicianAppointments/{technicianId}")
    public List<Appointment> getAppointmentByTechnicianId(@PathVariable Integer technicianId){
        return AppointmentRepo.findAllByTechnicianId(technicianId);
    }

    @PutMapping("/UpdateTechAppointmentStatus/{appointmentId}/{appointmentStatus}")
    Appointment updateStatus(@RequestBody Appointment update, @PathVariable Integer appointmentId, @PathVariable String appointmentStatus){
        return AppointmentRepo.findById(appointmentId)
                .map(appointment -> {
                    appointment.setStatus(appointmentStatus);

                    return AppointmentRepo.save(appointment);
                }).orElseThrow(()-> new UserNotFoundException(appointmentId));
    }

    @GetMapping("/TechAppointments/{technicianId}/{status}")
    public List<Appointment> getAppointmentByStatus(@PathVariable Integer technicianId, @PathVariable String status){
        return AppointmentRepo.findAllByTechnicianIdAndStatus(technicianId, status);
    }

    @DeleteMapping("/TechAppointments/{appointmentId}/{appointmentStatus}")
    public Appointment deleteAppointmentById(@PathVariable Integer appointmentId) {
        Appointment appointment = AppointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new UserNotFoundException(appointmentId));
        AppointmentRepo.delete(appointment);
        return appointment;
    }



}
