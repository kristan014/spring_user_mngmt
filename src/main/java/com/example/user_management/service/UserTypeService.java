package com.example.user_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user_management.model.UserType;
import com.example.user_management.repository.UserTypeRepository;

@Service
public class UserTypeService {


    @Autowired
    private final UserTypeRepository userTypeRepository;

    public UserTypeService(UserTypeRepository userTypeRepository){
        this.userTypeRepository = userTypeRepository;
    }


    public void create(){

    }

    public void update(Long id, UserType user){
        
    }

    public void delete(Long id){

    }

    public List<UserType> findAll(){
        return userTypeRepository.findAll();
    }

    public Optional<UserType> findOne(Long id){
        return userTypeRepository.findById(id);
    }
}
