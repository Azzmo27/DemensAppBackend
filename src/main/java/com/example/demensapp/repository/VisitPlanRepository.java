package com.example.demensapp.repository;

import com.example.demensapp.model.VisitPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisitPlanRepository extends JpaRepository<VisitPlan, Long> {
    Optional<VisitPlan> findByResidentId(Long residentId);
}
