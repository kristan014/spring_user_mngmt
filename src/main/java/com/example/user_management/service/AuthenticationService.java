package com.example.user_management.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.user_management.dto.RegisterRequest;
import com.example.user_management.repository.UserRepository;
import com.example.user_management.security.request.AuthenticationRequest;
import com.example.user_management.security.response.AuthenticationResponse;
import com.example.user_management.security.service.JwtService;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository,JwtService jwtService,AuthenticationManager authenticationManager){
        this.userRepository=userRepository;
        this.jwtService=jwtService;
        this.authenticationManager=authenticationManager;
    }
    

    public AuthenticationResponse register(RegisterRequest request){
        var user = User.builder().username(request.getUsername()).password(request.getPassword()).
        build();

        // userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse auth(AuthenticationRequest request){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        var user = userRepository.findUserByUsername(request.getUsername()).orElseThrow();
         // userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
