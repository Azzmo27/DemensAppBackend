package com.example.demensapp.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MedicationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Resident resident;

    private String medicationName;
    private LocalDateTime givenAt;

    @ManyToOne
    private User givenBy;

    public MedicationLog() {}

    public Long getId() { return id; }

    public Resident getResident() { return resident; }
    public void setResident(Resident resident) { this.resident = resident; }

    public String getMedicationName() { return medicationName; }
    public void setMedicationName(String medicationName) { this.medicationName = medicationName; }

    public LocalDateTime getGivenAt() { return givenAt; }
    public void setGivenAt(LocalDateTime givenAt) { this.givenAt = givenAt; }

    public User getGivenBy() { return givenBy; }
    public void setGivenBy(User givenBy) { this.givenBy = givenBy; }
}
