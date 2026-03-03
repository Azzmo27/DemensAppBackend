package com.example.demensapp.controller;



import com.example.demensapp.dto.StopEventRequest;
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

    @PostMapping("/stop/{eventId}")
    public Event stopEvent(
            @PathVariable Long eventId,
            @RequestBody StopEventRequest request
    ) {
        return eventService.stopEvent(
                eventId,
                request.getDescription(),
                request.getHelpedBy(),
                request.getTrigger()
        );
    }



}

