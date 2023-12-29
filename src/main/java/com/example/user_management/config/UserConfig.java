package com.example.user_management.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.user_management.model.User;
import com.example.user_management.model.UserType;
import com.example.user_management.repository.UserRepository;
import com.example.user_management.repository.UserTypeRepository;

@Configuration
public class UserConfig {
    
    @Bean
    CommandLineRunner commandLineRunner (
                                UserRepository userRepository,
                                UserTypeRepository userTypeRepository){
        return args -> {

            UserType super_admin = new UserType(
                "super admin",
                "manages all"
            );

            User tan = new User(
                "superAdmin",
                "12345",
                (long)1,
                LocalDate.of(2002, 03, 01),
                LocalDate.of(2020, 03, 01)
            );
            User wan = new User(
                "wan1234",
                "12345",
                (long)1,
                LocalDate.of(2002, 03, 01),
                LocalDate.of(2020, 03, 01)
            );

            userTypeRepository.save(super_admin);

            userRepository.saveAll(
                 List.of(tan,wan)
            );



        };
    }
    
}
