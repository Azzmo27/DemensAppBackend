package com.example.demensapp.dto;

public class StopEventRequest {

    private String description;
    private String helpedBy;
    private String trigger;

    public String getDescription() {
        return description;
    }

    public String getHelpedBy() {
        return helpedBy;
    }

    public String getTrigger() {
        return trigger;
    }
}