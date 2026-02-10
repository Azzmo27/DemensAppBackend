package com.example.demensapp.model;


import jakarta.persistence.*;

@Entity
public class EventDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Event event;

    @Column(length = 1000)
    private String description;

    private String whatHelped;
    private String possibleTrigger;
    private boolean injury;

    public EventDetail() {}

    public Long getId() { return id; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getWhatHelped() { return whatHelped; }
    public void setWhatHelped(String whatHelped) { this.whatHelped = whatHelped; }

    public String getPossibleTrigger() { return possibleTrigger; }
    public void setPossibleTrigger(String possibleTrigger) { this.possibleTrigger = possibleTrigger; }

    public boolean isInjury() { return injury; }
    public void setInjury(boolean injury) { this.injury = injury; }
}
