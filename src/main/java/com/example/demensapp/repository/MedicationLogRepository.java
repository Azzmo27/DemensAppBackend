package com.example.demensapp.repository;

import com.example.demensapp.model.MedicationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationLogRepository extends JpaRepository<MedicationLog, Long> {
}