package com.example.userservice.infrastructure.presenter.rest.authentication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String token_type = "Bearer";
    private String token;
    public AuthenticationResponse(String token){
        this.token = token;
    }
}
