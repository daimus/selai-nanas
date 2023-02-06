package com.example.userservice.infrastructure.presenter.rest.user;

import com.example.userservice.application.user.entity.User;
import com.example.userservice.application.user.service.UserService;
import com.example.userservice.infrastructure.presenter.rest.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<Object> getUsers(){
        log.info("GET /users/{id} called");
        Response response = new Response();
        List<User> users = userService.getUsers();
        response.setData(users);
        return response.getResponse();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Long id){
        log.info("GET /users/{id} called");
        Response response = new Response();
        User user = userService.getUserById(id);
        response.setData(user);
        return response.getResponse();
    }
    @PostMapping
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        log.info("GET /users/{id} called");
        Response response = new Response();
        user = userService.saveUser(user);
        response.setData(user);
        response.setHttpCode(201);
        return response.getResponse();
    }
    @PatchMapping(path = "/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User user){
        log.info("GET /users/{id} called");
        Response response = new Response();
        user = userService.saveUser(id, user);
        response.setData(user);
        return response.getResponse();
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id){
        log.info("GET /users/{id} called");
        Response response = new Response();
        userService.deleteUserById(id);
        response.setHttpCode(204);
        return response.getResponse();
    }
}
