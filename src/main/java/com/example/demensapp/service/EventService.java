package com.example.demensapp.service;

import com.example.demensapp.model.Event;
import com.example.demensapp.model.EventType;
import com.example.demensapp.model.Resident;
import com.example.demensapp.model.User;
import com.example.demensapp.repository.EventRepository;
import com.example.demensapp.repository.ResidentRepository;
import com.example.demensapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final ResidentRepository residentRepository;
    private final UserRepository userRepository;

    public EventService(EventRepository eventRepository,
                        ResidentRepository residentRepository,
                        UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.residentRepository = residentRepository;
        this.userRepository = userRepository;
    }

    public Event startEvent(Long residentId, EventType type, Long userId) {

        Event event = new Event();
        event.setResidentId(residentId);
        event.setCreatedById(userId);
        event.setType(type);
        event.setStartTime(LocalDateTime.now());

        return eventRepository.save(event);
    }

    public Event stopEvent(
            Long eventId,
            String description,
            String helpedBy,
            String trigger
    ) {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setEndTime(LocalDateTime.now());
        event.setDescription(description);
        event.setHelpedBy(helpedBy);
        event.setTrigger(trigger);

        return eventRepository.save(event);
    }}
