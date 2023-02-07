package com.example.userservice.infrastructure.presenter.rest.authentication;

import com.example.userservice.infrastructure.presenter.rest.Response;
import com.example.userservice.infrastructure.presenter.rest.authentication.dto.AuthenticationRequest;
import com.example.userservice.infrastructure.presenter.rest.authentication.dto.AuthenticationResponse;
import com.example.userservice.infrastructure.presenter.rest.authentication.util.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    @Autowired
    JwtUtil jwtUtil;
    @PostMapping
    public ResponseEntity<Object> signIn(@Valid @RequestBody AuthenticationRequest authenticationRequest){
        Response response = new Response();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );
        String token = jwtUtil.generateToken(authenticationRequest.getUsername());
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(token);
        response.setData(authenticationResponse);
        return response.getResponse();
    }
}
