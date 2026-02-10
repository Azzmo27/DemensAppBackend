package com.example.demensapp.repository;

import com.example.demensapp.model.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident,Long > {

}
