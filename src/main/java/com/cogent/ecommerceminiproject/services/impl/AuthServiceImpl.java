package com.cogent.ecommerceminiproject.services.impl;

import com.cogent.ecommerceminiproject.entities.Role;
import com.cogent.ecommerceminiproject.entities.User;
import com.cogent.ecommerceminiproject.payload.LoginPayload;
import com.cogent.ecommerceminiproject.payload.LoginResponse;
import com.cogent.ecommerceminiproject.payload.RegisterPayload;
import com.cogent.ecommerceminiproject.payload.RegisterResponse;
import com.cogent.ecommerceminiproject.repositories.RoleRepository;
import com.cogent.ecommerceminiproject.repositories.UserRepository;
import com.cogent.ecommerceminiproject.security.JwtTokenProvider;
import com.cogent.ecommerceminiproject.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public RegisterResponse register(RegisterPayload registerPayload) {
        // add check for username exists in database
        if(userRepository.existsByUsername(registerPayload.getUsername())){
            throw new RuntimeException("username is already exists!.");
        }
        // add check for email exists in database
        if(userRepository.existsByEmail(registerPayload.getEmail())){
            throw new RuntimeException("email is already exists!.");
        }

        User user = new User();
        user.setUsername(registerPayload.getUsername());
        user.setEmail(registerPayload.getEmail());
        user.setPassword(passwordEncoder.encode(registerPayload.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("user").get();
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);
        RegisterResponse response = new RegisterResponse();
        response.setMessage("User created successfully");
        return response;
    }

    @Override
    public LoginResponse login(LoginPayload loginPayload) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginPayload.getUsernameOrEmail(), loginPayload.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage("Login Successful");
        loginResponse.setToken(jwtTokenProvider.generateToken(authentication));
        return loginResponse;
    }


}
