package com.example.demensapp.service;

import com.example.demensapp.model.EventDetail;
import com.example.demensapp.repository.EventDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventDetailService {

    private final EventDetailRepository eventDetailRepository;

    public EventDetailService(EventDetailRepository eventDetailRepository) {
        this.eventDetailRepository = eventDetailRepository;
    }

    // Hent alle eventdetails
    public List<EventDetail> getAll() {
        return eventDetailRepository.findAll();
    }

    // Hent eventdetail by id
    public EventDetail getById(Long id) {
        return eventDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EventDetail ikke fundet"));
    }

    // Opret eller opdater eventdetail
    public EventDetail save(EventDetail eventDetail) {
        return eventDetailRepository.save(eventDetail);
    }

    // Slet eventdetail
    public void delete(Long id) {
        eventDetailRepository.deleteById(id);
    }
}