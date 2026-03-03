package com.example.demensapp.controller;
import com.example.demensapp.model.*;
import com.example.demensapp.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/residents")
public class ResidentController {

    private final ResidentRepository residentRepository;
    private final ObservationRepository observationRepository;
    private final MedicationRepository medicationRepository;
    private final EventRepository eventRepository;

    private final VisitPlanRepository visitPlanRepository;

    public ResidentController(ResidentRepository residentRepository,
                              ObservationRepository observationRepository,
                              MedicationRepository medicationRepository, EventRepository eventRepository, VisitPlanRepository visitPlanRepository) {
        this.residentRepository = residentRepository;
        this.observationRepository = observationRepository;
        this.medicationRepository = medicationRepository;
        this.eventRepository = eventRepository;
        this.visitPlanRepository = visitPlanRepository;
    }
    // ResidentController.java eller EventController.java
    @GetMapping("/{id}/events")
    public List<Event> getResidentEvents(@PathVariable Long id) {
        return eventRepository.findByResidentIdOrderByStartTimeDesc(id);
    }

    // GET /residents → Alle beboere
    @GetMapping
    public List<Resident> getAllResidents() {
        return residentRepository.findAll();
    }

    // GET /residents/{id} → Hent én beboer
    @GetMapping("/{id}")
    public Resident getResidentById(@PathVariable Long id) {
        return residentRepository.findById(id).orElse(null);
    }

    // 🔹 GET /residents/{id}/observations → Liste af observationer
    @GetMapping("/{id}/observations")
    public List<Observation> getObservations(@PathVariable Long id) {
        return observationRepository.findByResidentIdOrderByCreatedAtDesc(id);
    }

    // 🔹 POST /residents/{id}/observations → Opret ny observation
    @PostMapping("/{id}/observations")
    public Observation createObservation(@PathVariable Long id, @RequestBody Observation obs) {
        Resident resident = residentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resident not found"));
        obs.setResident(resident); // virker nu
        return observationRepository.save(obs);
    }
    // src/main/java/com/example/demensapp/controller/ResidentController.java
    @GetMapping("/{id}/medications")
    public List<Medication> getMedications(@PathVariable Long id) {
        return medicationRepository.findByResidentId(id);
    }




    // 🔹 GET /residents/{id}/medication-count → Antal medicin per dag
    @GetMapping("/{id}/medication-count")
    public int getMedicationCount(@PathVariable Long id) {
        return medicationRepository.findByResidentId(id)
                .stream()
                .mapToInt(Medication::getTimesPerDay)
                .sum();
    }
    // 🔹 GET /residents/{id}/visit-plan
    @GetMapping("/{id}/visit-plan")
    public VisitPlan getVisitPlan(@PathVariable Long id) {
        return visitPlanRepository.findByResidentId(id)
                .orElse(null); // returner null hvis ingen besøgsplan
    }

}
