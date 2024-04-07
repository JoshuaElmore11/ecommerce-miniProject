package com.cogent.ecommerceminiproject.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterPayload {
    public String username;
    public String email;
    public String password;

}
