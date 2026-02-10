package com.example.demensapp.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Resident resident;

    @Enumerated(EnumType.STRING)
    private EventType type;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private User createdBy;

    public Event() {}

    public Long getId() { return id; }

    public Resident getResident() { return resident; }
    public void setResident(Resident resident) { this.resident = resident; }

    public EventType getType() { return type; }
    public void setType(EventType type) { this.type = type; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public User getCreatedBy() { return createdBy; }
    public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }
}
