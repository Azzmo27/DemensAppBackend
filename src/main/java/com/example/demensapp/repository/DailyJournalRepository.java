package com.example.demensapp.repository;

import com.example.demensapp.model.DailyJournal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyJournalRepository extends JpaRepository<DailyJournal, Long> {
}