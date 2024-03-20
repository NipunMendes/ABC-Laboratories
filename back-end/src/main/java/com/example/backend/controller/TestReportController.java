package com.example.backend.controller;

import com.example.backend.service.TestReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class TestReportController {

    @Autowired
    private TestReportService testReportService;

    @PutMapping("/UploadTestReport/{Id}")
    public ResponseEntity<String> uploadTestReport(
            @PathVariable("appointmentId") String appointmentId,
            @RequestParam("date") String date,
            @RequestParam("time") String time,
            @RequestParam("file") MultipartFile file) {
        try {
            testReportService.uploadTestReport(appointmentId, date, time, file);
            return ResponseEntity.ok("File uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to upload file: " + e.getMessage());
        }
    }
}
