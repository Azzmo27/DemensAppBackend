package com.example.demensapp.config;

import com.example.demensapp.model.*;
import com.example.demensapp.repository.MedicationRepository;
import com.example.demensapp.repository.ResidentRepository;
import com.example.demensapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(UserRepository userRepository,
                               ResidentRepository residentRepository,
                               MedicationRepository medicationRepository) {
        return args -> {

            if (userRepository.count() == 0) {
                User user = new User();
                user.setName("Test Personale");
                user.setEmail("test@pleje.dk");
                user.setRole(UserRole.STAFF);
                userRepository.save(user);
            }

            if (residentRepository.count() == 0) {

                createResident(residentRepository, medicationRepository,
                        "Anna Jensen","12","120845-1234");

                createResident(residentRepository, medicationRepository,
                        "Karen Larsen","14","030950-4421");

                createResident(residentRepository, medicationRepository,
                        "Lise Madsen","16","220343-3321");

                createResident(residentRepository, medicationRepository,
                        "Jens Nielsen","18","110239-9933");

                createResident(residentRepository, medicationRepository,
                        "Peter Hansen","20","090847-7712");

                createResident(residentRepository, medicationRepository,
                        "Ole Sørensen","22","170640-5532");
            }
        };
    }

    private void createResident(ResidentRepository residentRepository,
                                MedicationRepository medicationRepository,
                                String name,
                                String room,
                                String cpr) {

        Resident resident = new Resident();
        resident.setName(name);
        resident.setRoomNumber(room);
        resident.setCprNumber(cpr);
        residentRepository.save(resident);

        createMedication(medicationRepository,resident,"Paracetamol 500mg","2",TimeOfDay.MORGEN);
        createMedication(medicationRepository,resident,"Vitamin D","1",TimeOfDay.MIDDAG);
        createMedication(medicationRepository,resident,"Ibuprofen 400mg","1",TimeOfDay.AFTEN);
        createMedication(medicationRepository,resident,"Melatonin","1",TimeOfDay.NAT);
    }

    private void createMedication(MedicationRepository medicationRepository,
                                  Resident resident,
                                  String name,
                                  String dose,
                                  TimeOfDay time){

        Medication med = new Medication();
        med.setName(name);
        med.setDose(dose);
        med.setTimeOfDay(time);
        med.setResident(resident);

        medicationRepository.save(med);
    }
}