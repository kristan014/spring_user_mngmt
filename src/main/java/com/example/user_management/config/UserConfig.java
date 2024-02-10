package com.example.user_management.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.user_management.enums.Role;
import com.example.user_management.model.User;
import com.example.user_management.model.UserType;
import com.example.user_management.repository.UserRepository;
import com.example.user_management.repository.UserTypeRepository;

@Configuration
public class UserConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @SuppressWarnings("null")
    @Bean
    CommandLineRunner commandLineRunner (
                                UserRepository userRepository,
                                UserTypeRepository userTypeRepository){
        Role userRole = Role.ADMIN;

        return args -> {

            UserType super_admin = new UserType(
                "super admin",
                "manages all"
            );

            User tan = new User(
                "superAdmin",
                passwordEncoder.encode("12345"),
                (long)1,
                LocalDate.of(2002, 03, 01),
                LocalDate.of(2020, 03, 01),
                userRole
            );
            User wan = new User(
                "wan1234",
                passwordEncoder.encode("12345"),
                (long)1,
                LocalDate.of(2002, 03, 01),
                LocalDate.of(2020, 03, 01), userRole
            );

            userTypeRepository.save(super_admin);

            userRepository.saveAll(
                 List.of(tan,wan)
            );



        };
    }
    
}
