package com.example.demensapp.model;

import jakarta.persistence.*;

@Entity
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Resident resident;

    private String name;
    private String dose;
    private int timesPerDay;

    // Getters
    public Long getId() { return id; }
    public Resident getResident() { return resident; }
    public String getName() { return name; }
    public String getDose() { return dose; }
    public int getTimesPerDay() { return timesPerDay; }
    @Enumerated(EnumType.STRING)
    private TimeOfDay timeOfDay;

    public TimeOfDay getTimeOfDay() { return timeOfDay; }
    public void setTimeOfDay(TimeOfDay timeOfDay) { this.timeOfDay = timeOfDay; }

    // Setters
    public void setResident(Resident resident) { this.resident = resident; }
    public void setName(String name) { this.name = name; }
    public void setDose(String dose) { this.dose = dose; }
    public void setTimesPerDay(int timesPerDay) { this.timesPerDay = timesPerDay; }
}
