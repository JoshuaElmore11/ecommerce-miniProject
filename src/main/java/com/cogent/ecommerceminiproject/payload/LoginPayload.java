package com.cogent.ecommerceminiproject.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginPayload {
    public String usernameOrEmail;
    public String password;
}
