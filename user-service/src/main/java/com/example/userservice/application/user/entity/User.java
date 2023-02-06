package com.example.userservice.application.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String photo;
    private String role;
    private String address;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
}
