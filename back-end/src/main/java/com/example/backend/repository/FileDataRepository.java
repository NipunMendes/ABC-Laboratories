package com.example.backend.repository;

import com.example.backend.model.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FileDataRepository extends JpaRepository<UploadedFile, Long>{
}
