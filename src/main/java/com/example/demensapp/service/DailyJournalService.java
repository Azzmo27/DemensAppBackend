package com.example.demensapp.service;

import com.example.demensapp.model.DailyJournal;
import com.example.demensapp.repository.DailyJournalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyJournalService {

    private final DailyJournalRepository dailyJournalRepository;

    public DailyJournalService(DailyJournalRepository dailyJournalRepository) {
        this.dailyJournalRepository = dailyJournalRepository;
    }

    public List<DailyJournal> getAll() {
        return dailyJournalRepository.findAll();
    }

    public DailyJournal getById(Long id) {
        return dailyJournalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Journal ikke fundet"));
    }

    public DailyJournal save(DailyJournal journal) {
        return dailyJournalRepository.save(journal);
    }

    public void delete(Long id) {
        dailyJournalRepository.deleteById(id);
    }
}