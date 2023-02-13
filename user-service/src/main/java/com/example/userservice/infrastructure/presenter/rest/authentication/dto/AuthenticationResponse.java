package com.example.userservice.infrastructure.presenter.rest.authentication.dto;

import com.example.userservice.application.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String token_type = "Bearer";
    private String token;
    private HashMap<String, Object> user = new HashMap<>();
    public AuthenticationResponse(String token){
        this.token = token;
    }

    public void setUser(User authenticatedUser) {
        user.put("id", authenticatedUser.getId());
        user.put("username", authenticatedUser.getUsername());
        user.put("email", authenticatedUser.getEmail());
        user.put("fullname", authenticatedUser.getFullname());
        user.put("role", authenticatedUser.getRole());
    }
}
