package com.example.backend.service;

import com.example.backend.model.TestReport;
import com.example.backend.repository.TestReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class TestReportService {

    @Autowired
    private TestReportRepository testReportRepository;

    public void uploadTestReport(String appointmentId, String date, String time, MultipartFile file) throws IOException {
        TestReport testReport = new TestReport();
        testReport.setAppointmentId(appointmentId);
        testReport.setDate(date);
        testReport.setTime(time);
        testReport.setFileData(file.getBytes());
        testReportRepository.save(testReport);
    }
}
