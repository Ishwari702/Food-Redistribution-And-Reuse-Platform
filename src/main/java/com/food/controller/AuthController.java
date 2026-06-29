package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.DTO.LoginDTO;
import com.food.DTO.RegisterDTO;
import com.food.service.AuthServiceImpl;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
@Autowired
private AuthServiceImpl authService;

@PostMapping("/register")
public String register(@RequestBody RegisterDTO request) {
	return authService.register(request);
}

@PostMapping("/login")
public String register(@RequestBody LoginDTO request) {
	return authService.logIn(request);
}
}
