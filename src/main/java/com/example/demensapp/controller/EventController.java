package com.example.demensapp.controller;



import com.example.demensapp.model.Event;
import com.example.demensapp.model.EventType;
import com.example.demensapp.repository.EventRepository;
import com.example.demensapp.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;
    private final EventRepository eventRepository;

    public EventController(EventService eventService, EventRepository eventRepository) {
        this.eventService = eventService;
        this.eventRepository = eventRepository;
    }

    // ▶ START hændelse
    @PostMapping("/start")
    public Event startEvent(
            @RequestParam Long residentId,
            @RequestParam EventType type,
            @RequestParam Long userId
    ) {
        return eventService.startEvent(residentId, type, userId);
    }

    // ⏹ STOP hændelse
    @PostMapping("/stop/{eventId}")
    public Event stopEvent(@PathVariable Long eventId) {
        return eventService.stopEvent(eventId);
    }


    // ResidentController.java eller EventController.java
    @GetMapping("/residents/{id}/events")
    public List<Event> getResidentEvents(@PathVariable Long id) {
        return eventRepository.findByResidentIdOrderByStartTimeDesc(id);
    }

}

