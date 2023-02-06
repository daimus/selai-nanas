package com.example.userservice.application.user.service;

import com.example.userservice.application.user.entity.User;
import com.example.userservice.application.user.repository.UserRepository;
import com.example.userservice.application.user.usecase.UserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {
    private final UserRepository userRepository;
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(@Valid User user) {
        return userRepository.save(user);
    }

    @Override
    public User saveUser(Long id, @Valid User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUserById(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
