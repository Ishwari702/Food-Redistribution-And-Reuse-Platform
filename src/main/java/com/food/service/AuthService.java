package com.food.service;

import com.food.DTO.ApiResponse;
import com.food.DTO.LoginDTO;
import com.food.DTO.RegisterDTO;

public interface AuthService {
	String register(RegisterDTO registerRequest);

	String logIn(LoginDTO loginRequest);
}
