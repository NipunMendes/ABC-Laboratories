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

    @GetMapping("/DoctorAppointments/{doctorId}")
    public List<Appointment> getAppointmentByDoctorId(@PathVariable Integer doctorId){
        return AppointmentRepo.findAllByDoctorId(doctorId);
    }

    @PutMapping("/UpdateAppointmentStatus/{appointmentId}/{appointmentStatus}")
    Appointment updateStatus(@RequestBody Appointment update, @PathVariable Integer appointmentId, @PathVariable String appointmentStatus){
        return AppointmentRepo.findById(appointmentId)
                .map(appointment -> {
                    appointment.setStatus(appointmentStatus);

                    return AppointmentRepo.save(appointment);
                }).orElseThrow(()-> new UserNotFoundException(appointmentId));
    }

    @GetMapping("/Appointments/{doctorId}/{status}")
    public List<Appointment> getAppointmentByStatus(@PathVariable Integer doctorId, @PathVariable String status){
        return AppointmentRepo.findAllByDoctorIdAndStatus(doctorId, status);
    }
}
