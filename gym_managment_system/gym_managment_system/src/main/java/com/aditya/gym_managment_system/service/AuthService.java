package com.aditya.gym_managment_system.service;

import com.aditya.gym_managment_system.dto.LoginRequest;
import com.aditya.gym_managment_system.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}