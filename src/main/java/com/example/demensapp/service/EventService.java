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
        Resident resident = residentRepository.findById(residentId)
                .orElseThrow(() -> new RuntimeException("Resident ikke fundet"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User ikke fundet"));

        Event event = new Event();
        event.setResident(resident);
        event.setType(type);
        event.setStartTime(LocalDateTime.now());
        event.setCreatedBy(user);

        return eventRepository.save(event);
    }


    public Event stopEvent(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Hændelse ikke fundet"));

        event.setEndTime(LocalDateTime.now());

        return eventRepository.save(event);
    }
}

