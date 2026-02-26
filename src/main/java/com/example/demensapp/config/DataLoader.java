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

            // ➤ Opret testpersonale
            if (userRepository.count() == 0) {
                User user = new User();
                user.setName("Test Personale");
                user.setEmail("test@pleje.dk");
                user.setRole(UserRole.STAFF);
                userRepository.save(user);
            }

            // ➤ Opret beboer og medicin
            if (residentRepository.count() == 0) {
                Resident resident = new Resident();
                resident.setName("Anna Jensen");
                resident.setRoomNumber("12");
                residentRepository.save(resident);

                // Medicin
                Medication med1 = new Medication();
                med1.setName("Paracetamol 500mg");
                med1.setDose(String.valueOf(2));
                med1.setTimeOfDay(TimeOfDay.valueOf("MORGEN"));
                med1.setResident(resident);  // sæt beboer
                medicationRepository.save(med1);

                Medication med2 = new Medication();
                med2.setName("Ibuprofen 400mg");
                med2.setDose(String.valueOf(2));
                med2.setTimeOfDay(TimeOfDay.valueOf("MIDDAG"));
                med2.setResident(resident);
                medicationRepository.save(med2);

                Medication med3 = new Medication();
                med3.setName("slaksijdc 400mg");
                med3.setDose(String.valueOf(2));
                med3.setTimeOfDay(TimeOfDay.valueOf("AFTEN"));
                med3.setResident(resident);
                medicationRepository.save(med3);

                Medication med4 = new Medication();
                med4.setName("Ibuprofen 400mg, sksk, sjsjjs, ");
                med4.setDose(String.valueOf(12));
                med4.setTimeOfDay(TimeOfDay.valueOf("NAT"));
                med4.setResident(resident);
                medicationRepository.save(med4);
            }
        };
    }
}
