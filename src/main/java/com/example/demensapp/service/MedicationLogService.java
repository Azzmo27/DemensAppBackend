package com.example.demensapp.service;

import com.example.demensapp.model.MedicationLog;
import com.example.demensapp.repository.MedicationLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationLogService {

    private final MedicationLogRepository medicationLogRepository;

    public MedicationLogService(MedicationLogRepository medicationLogRepository) {
        this.medicationLogRepository = medicationLogRepository;
    }

    public List<MedicationLog> getAll() {
        return medicationLogRepository.findAll();
    }

    public MedicationLog getById(Long id) {
        return medicationLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicinlog ikke fundet"));
    }

    public MedicationLog save(MedicationLog log) {
        return medicationLogRepository.save(log);
    }

    public void delete(Long id) {
        medicationLogRepository.deleteById(id);
    }
}