package com.example.demensapp.model;

import jakarta.persistence.*;

@Entity
public class VisitPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Resident resident;

    // eksisterende felter
    @Column(length = 2000)
    private String purpose;

    @Column(length = 3000)
    private String support;

    @Column(length = 3000)
    private String actions;

    @Column(length = 3000)
    private String specialAttention;

    // ✅ NYT: Døgnrytmeplan pr vagt (fold ud i UI)
    @Column(length = 4000)
    private String dayPlan;

    @Column(length = 4000)
    private String eveningPlan;

    @Column(length = 4000)
    private String nightPlan;

    // getters/setters (lav dem alle)
    public Long getId() { return id; }

    public Resident getResident() { return resident; }
    public void setResident(Resident resident) { this.resident = resident; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public String getSupport() { return support; }
    public void setSupport(String support) { this.support = support; }

    public String getActions() { return actions; }
    public void setActions(String actions) { this.actions = actions; }

    public String getSpecialAttention() { return specialAttention; }
    public void setSpecialAttention(String specialAttention) { this.specialAttention = specialAttention; }

    public String getDayPlan() { return dayPlan; }
    public void setDayPlan(String dayPlan) { this.dayPlan = dayPlan; }

    public String getEveningPlan() { return eveningPlan; }
    public void setEveningPlan(String eveningPlan) { this.eveningPlan = eveningPlan; }

    public String getNightPlan() { return nightPlan; }
    public void setNightPlan(String nightPlan) { this.nightPlan = nightPlan; }
}