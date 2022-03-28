package com.example.wicket.services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean login(String email, String pass) {
        return email.equals(pass);
    }
}
