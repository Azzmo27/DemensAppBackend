package com.example.demensapp.repository;

import com.example.demensapp.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByResidentIdOrderByStartTimeDesc(Long residentId);
}


