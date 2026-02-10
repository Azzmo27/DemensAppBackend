package com.example.demensapp.config;


import com.example.demensapp.model.Resident;
import com.example.demensapp.model.User;
import com.example.demensapp.model.UserRole;
import com.example.demensapp.repository.ResidentRepository;
import com.example.demensapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(UserRepository userRepository,
                               ResidentRepository residentRepository) {
        return args -> {

            if (userRepository.count() == 0) {
                User user = new User();
                user.setName("Test Personale");
                user.setEmail("test@pleje.dk");
                user.setRole(UserRole.STAFF);
                userRepository.save(user);
            }

            if (residentRepository.count() == 0) {
                Resident resident = new Resident();
                resident.setName("Anna Jensen");
                resident.setRoomNumber("12");
                residentRepository.save(resident);
            }
        };
    }
}
