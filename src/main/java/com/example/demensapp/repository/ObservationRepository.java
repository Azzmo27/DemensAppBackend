package com.example.demensapp.repository;

import com.example.demensapp.model.Observation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObservationRepository extends JpaRepository<Observation, Long> {
    List<Observation> findByResidentIdOrderByCreatedAtDesc(Long residentId);
}
