package com.example.userservice.application.user.repository;

import com.example.userservice.application.user.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById(Long id);
    User findUserByUsername(String username);
    User save(User user);
    boolean deleteById(Long id);
}
