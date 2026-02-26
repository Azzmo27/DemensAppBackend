package com.example.demensapp.repository;

import com.example.demensapp.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
    int countByResidentId(Long residentId);
    List<Medication> findByResidentId(Long residentId);

}
