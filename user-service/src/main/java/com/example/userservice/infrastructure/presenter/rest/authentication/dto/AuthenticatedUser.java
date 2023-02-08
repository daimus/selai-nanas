package com.example.userservice.infrastructure.presenter.rest.authentication.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class AuthenticatedUser extends User {
    private final Long userId;
    public AuthenticatedUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Long userId) {
        super(username, password, authorities);
        this.userId = userId;
    }

    public Long getUserId(){
        return this.userId;
    }
}
