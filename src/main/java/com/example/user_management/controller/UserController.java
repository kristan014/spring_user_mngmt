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

import com.example.user_management.model.User;
import com.example.user_management.service.UserService;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public void create(){
         userService.create();
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable Long id, @RequestBody User user){
        userService.update(id, user);
    }

    @GetMapping(path= "{id}")
    public Optional<User> findOne(@PathVariable Long id){
        return userService.findOne(id);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
