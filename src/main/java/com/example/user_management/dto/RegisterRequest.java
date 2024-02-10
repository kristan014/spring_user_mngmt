package com.example.user_management.dto;

public class RegisterRequest {
private String firstname;
private String lastname;
private String email;
private String username;

private String password;


public String getFirstName(){
    return firstname;
}

public String getLastName(){
    return lastname;
}


public String getEmail(){
    return email;
}

public String getUsername(){
    return username;
}

public String getPassword(){
    return password;
}


}
