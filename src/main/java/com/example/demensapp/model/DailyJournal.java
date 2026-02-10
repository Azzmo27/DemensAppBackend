package com.example.demensapp.model;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DailyJournal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Resident resident;

    private LocalDate date;

    private String mood;
    private String sleep;
    private String appetite;

    @Column(length = 1000)
    private String note;

    @ManyToOne
    private User createdBy;

    public DailyJournal() {}

    public Long getId() { return id; }

    public Resident getResident() { return resident; }
    public void setResident(Resident resident) { this.resident = resident; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getMood() { return mood; }
    public void setMood(String mood) { this.mood = mood; }

    public String getSleep() { return sleep; }
    public void setSleep(String sleep) { this.sleep = sleep; }

    public String getAppetite() { return appetite; }
    public void setAppetite(String appetite) { this.appetite = appetite; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public User getCreatedBy() { return createdBy; }
    public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }
}
