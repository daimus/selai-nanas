package com.example.userservice.application.user.usecase;

import com.example.userservice.application.user.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserUseCase {
    List<User> getUsers();
    Page<User> getUsers(Integer page, Integer size);
    User getUserById(Long id);
    User getUserByUsername(String username);
    User saveUser(User user);
    User saveUser(Long id, User user);
    boolean deleteUserById(Long id);

}
