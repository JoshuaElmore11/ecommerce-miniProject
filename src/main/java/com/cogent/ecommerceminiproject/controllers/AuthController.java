package com.cogent.ecommerceminiproject.controllers;

import com.cogent.ecommerceminiproject.payload.LoginPayload;
import com.cogent.ecommerceminiproject.payload.LoginResponse;
import com.cogent.ecommerceminiproject.payload.RegisterPayload;
import com.cogent.ecommerceminiproject.payload.RegisterResponse;
import com.cogent.ecommerceminiproject.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<LoginResponse> login(@RequestBody LoginPayload loginPayload) {
        var response = authService.login(loginPayload);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = {"/register", "signup"})
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterPayload registerPayload) {
        var response = authService.register(registerPayload);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
