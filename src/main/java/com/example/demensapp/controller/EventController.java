package com.example.demensapp.controller;



import com.example.demensapp.model.Event;
import com.example.demensapp.model.EventType;
import com.example.demensapp.service.EventService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
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
}
