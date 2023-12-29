package com.example.user_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user_management.model.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {
    
}
