package com.example.demensapp.service;

import com.example.demensapp.model.Notification;
import com.example.demensapp.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    // Hent alle notifikationer
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    // Hent notifikation by id
    public Notification getById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notifikation ikke fundet"));
    }

    // Opret eller opdater notifikation
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    // Slet notifikation
    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }
}