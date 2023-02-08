package com.example.userservice.infrastructure.presenter.rest.authentication.service;

import com.example.userservice.application.user.entity.User;
import com.example.userservice.application.user.usecase.UserUseCase;
import com.example.userservice.infrastructure.presenter.rest.authentication.dto.AuthenticatedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserUseCase userUseCase;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userUseCase.getUserByUsername(username);
        return new AuthenticatedUser(
                user.getUsername(), user.getPassword(), getAuthorities(user.getRole()), user.getId());
    }

    public Collection<? extends GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }
}