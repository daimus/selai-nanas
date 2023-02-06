package com.example.userservice.application.user.usecase;

import com.example.userservice.application.user.entity.User;

import java.util.List;

public interface UserUseCase {
    List<User> getUsers();
    User getUserById(Long id);
    User saveUser(User user);
    User saveUser(Long id, User user);
    boolean deleteUserById(Long id);

}
