package com.example.backend.repository;

import com.example.backend.model.TestReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestReportRepository extends JpaRepository<TestReport, Long> {
}
