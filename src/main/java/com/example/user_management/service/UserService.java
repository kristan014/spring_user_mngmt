package com.example.user_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user_management.repository.UserRepository;
import com.example.user_management.model.User;

@Service
public class UserService {
    
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public void create(){

    }

    public void update(){
        
    }

    public void delete(){

    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findOne(Long id){
        return userRepository.findById(id);
    }
}
