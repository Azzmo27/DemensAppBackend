package com.example.demensapp.service;


import com.example.demensapp.model.Resident;
import com.example.demensapp.repository.ResidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentService {

    private final ResidentRepository residentRepository;

    public ResidentService(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    public List<Resident> getAllResidents() {
        return residentRepository.findAll();
    }

    public Resident getResidentById(Long id) {
        return residentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resident ikke fundet"));
    }

    public Resident saveResident(Resident resident) {
        return residentRepository.save(resident);
    }

    public void deleteResident(Long id) {
        residentRepository.deleteById(id);
    }
}