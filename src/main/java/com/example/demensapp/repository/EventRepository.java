package com.example.demensapp.repository;


import com.example.demensapp.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}

