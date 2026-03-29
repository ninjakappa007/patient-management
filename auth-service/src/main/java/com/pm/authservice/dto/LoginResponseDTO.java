package com.pm.authservice.dto;

public class LoginResponseDTO {
    private final String token;

//    Add refresh token later

    public LoginResponseDTO(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
