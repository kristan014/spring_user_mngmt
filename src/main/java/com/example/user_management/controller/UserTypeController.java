package com.example.user_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_management.model.UserType;
import com.example.user_management.service.UserTypeService;

@RestController
@RequestMapping(path = "api/v1/user-types")
public class UserTypeController {
        private final UserTypeService userTypeService;

    public UserTypeController(UserTypeService userTypeService){
        this.userTypeService = userTypeService;
    }
    

    @GetMapping
    public List<UserType> findAll(){
        return userTypeService.findAll();
    }

    @PostMapping
    public void create(){
         userTypeService.create();
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable Long id, @RequestBody UserType user){
        userTypeService.update(id, user);
    }

    @GetMapping(path= "{id}")
    public Optional<UserType> findOne(@PathVariable Long id){
        return userTypeService.findOne(id);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Long id){
        userTypeService.delete(id);
    }
}
