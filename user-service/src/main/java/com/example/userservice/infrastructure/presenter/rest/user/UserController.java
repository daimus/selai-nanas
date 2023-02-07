package com.example.userservice.infrastructure.presenter.rest.user;

import com.example.userservice.application.user.entity.User;
import com.example.userservice.application.user.usecase.UserUseCase;
import com.example.userservice.infrastructure.presenter.rest.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserUseCase userUseCase;
    @GetMapping
    public ResponseEntity<Object> getUsers(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "10") Integer size){
        log.info("GET /users called with param page: {}, size: {}", page, size);
        Response response = new Response();
        Page<User> users = userUseCase.getUsers(page, size);
        response.setPageData(users);
        return response.getResponse();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Long id){
        log.info("GET /users/{} called", id);
        Response response = new Response();
        User user = userUseCase.getUserById(id);
        response.setData(user);
        return response.getResponse();
    }
    @PostMapping
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        log.info("POST /users called with body: {}", user);
        Response response = new Response();
        user = userUseCase.saveUser(user);
        response.setData(user);
        response.setHttpCode(201);
        return response.getResponse();
    }
    @PatchMapping(path = "/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User user){
        log.info("PATCH /users/{} called with body: {}", id, user);
        Response response = new Response();
        user = userUseCase.saveUser(id, user);
        response.setData(user);
        return response.getResponse();
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id){
        log.info("DELETE /users/{} called", id);
        Response response = new Response();
        userUseCase.deleteUserById(id);
        response.setHttpCode(204);
        return response.getResponse();
    }
}
