package com.example.user_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user_management.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findUserByUsername(String userName);
    // Optional<User> findStudentById(Long id);
}
