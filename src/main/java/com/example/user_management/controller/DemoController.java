package com.example.user_management.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("api/v1/demo-controller")
public class DemoController {
    

    @GetMapping
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }
    
}
