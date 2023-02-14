package com.example.userservice.application.user.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    @NotEmpty(message = "Username is required")
    private String username;
    private String password;
    @NotEmpty(message = "Fullname is required")
    private String fullname;
    @NotEmpty(message = "Email is required")
    @Email
    private String email;
    @NotEmpty(message = "Photo is required")
    private String photo;
    private String role;
    @NotEmpty(message = "Address is required")
    private String address;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
}
