package com.example.user_management.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.user_management.model.User;
import com.example.user_management.repository.UserRepository;

@Configuration
public class UserConfig {
    
    @Bean
    CommandLineRunner commandLineRunner (UserRepository userRepository){
        return args -> {
            User tan = new User(
                "tan1234",
                "12345",
                LocalDate.of(2002, 03, 01),
                LocalDate.of(2020, 03, 01)
            );
            User wan = new User(
                "wan1234",
                "12345",
                LocalDate.of(2002, 03, 01),
                LocalDate.of(2020, 03, 01)
            );

            userRepository.saveAll(
                 List.of(tan,wan)
            );
        };
    }
    
}
