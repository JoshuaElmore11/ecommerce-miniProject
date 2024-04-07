package com.cogent.ecommerceminiproject.services;

import com.cogent.ecommerceminiproject.entities.User;
import com.cogent.ecommerceminiproject.payload.LoginPayload;
import com.cogent.ecommerceminiproject.payload.LoginResponse;
import com.cogent.ecommerceminiproject.payload.RegisterPayload;
import com.cogent.ecommerceminiproject.payload.RegisterResponse;

public interface AuthService {
    public RegisterResponse register(RegisterPayload registerPayload);

    public LoginResponse login(LoginPayload loginPayload);
}
