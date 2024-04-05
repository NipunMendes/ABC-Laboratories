package com.example.backend.controller;

import com.example.backend.exception.UserNotFoundException;
import com.example.backend.model.Appointment;
import com.example.backend.repository.AppointmentRepository;
import com.example.backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class AppointmentController {

    @Autowired
    private AppointmentRepository AppointmentRepo;
    private PatientRepository PatientRepo;

    @PostMapping("/MakeAppointment")
    public ResponseEntity<Appointment> newAppointment(@RequestBody Appointment newAppointment){
        AppointmentRepo.save(newAppointment);
        return ResponseEntity.ok(newAppointment);
    }

    @GetMapping("/Appointments")
    public List<Appointment> getAppointments(){
        return AppointmentRepo.findAll();
    }

    @GetMapping("/Appointments/{status}")
    public List<Appointment> getAppointmentsByStatus(@PathVariable String status){
        return AppointmentRepo.findAllByStatus(status);
    }

    @GetMapping("/PatientAppointments/{patientId}")
    public List<Appointment> getAppointmentByPatientId(@PathVariable Integer patientId){
        return AppointmentRepo.findAllByPatientId(patientId);
    }

    @GetMapping("/TechnicianAppointments/{technicianId}")
    public List<Appointment> getAppointmentByDoctorId(@PathVariable Integer technicianId){
        return AppointmentRepo.findAllByTechnicianId(technicianId);
    }

    @PutMapping("/UpdateAppointmentStatus/{appointmentId}/{appointmentStatus}")
    Appointment updateStatus(@RequestBody Appointment update, @PathVariable Integer appointmentId, @PathVariable String appointmentStatus){
        return AppointmentRepo.findById(appointmentId)
                .map(appointment -> {
                    appointment.setStatus(appointmentStatus);

                    return AppointmentRepo.save(appointment);
                }).orElseThrow(()-> new UserNotFoundException(appointmentId));
    }
    
    @GetMapping("/Appointments/{technicianId}/{status}")
    public List<Appointment> getAppointmentByStatus(@PathVariable Integer technicianId, @PathVariable String status){
        return AppointmentRepo.findAllByTechnicianIdAndStatus(technicianId, status);
    }

    @DeleteMapping("/Appointments/{appointmentId}/{status}")
    public Appointment deleteAppointmentById(@PathVariable Integer appointmentId) {
        Appointment appointment = AppointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new UserNotFoundException(appointmentId));
        AppointmentRepo.delete(appointment);
        return appointment;
    }

    @DeleteMapping("/PatientAppointments/{appointmentId}/{status}")
    public Appointment deletePatientAppointmentById(@PathVariable Integer appointmentId) {
        Appointment appointment = AppointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new UserNotFoundException(appointmentId));
        AppointmentRepo.delete(appointment);
        return appointment;
    }

    @PutMapping("/UploadTestReport/{appointmentId}")
    Appointment uploadTest(@RequestBody Appointment update, @PathVariable Integer appointmentId){
        return AppointmentRepo.findById(appointmentId)
                .map(appointment -> {

                    return AppointmentRepo.save(appointment);
                }).orElseThrow(()-> new UserNotFoundException(appointmentId));
    }



}
