package com.example.user_management.security.response;

import lombok.Builder;

@Builder
public class AuthenticationResponse {

    private String token;

    public String getToken(){
        return token;
    }
}
