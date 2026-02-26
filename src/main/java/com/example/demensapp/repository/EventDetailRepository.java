package com.example.demensapp.repository;

import com.example.demensapp.model.EventDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventDetailRepository extends JpaRepository<EventDetail, Long> {
}