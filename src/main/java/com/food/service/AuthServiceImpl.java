package com.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.DTO.LoginDTO;
import com.food.DTO.RegisterDTO;
import com.food.Exception.ResourceNotFoundException;
import com.food.entities.User;
import com.food.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthServiceImpl implements AuthService{
@Autowired private UserRepository userRepo;
	
	@Override
	public String register(RegisterDTO registerRequest) {

		if(userRepo.existsByEmail(registerRequest.getEmail())) {
			return "Email already exists";
		}
		
		User user=new User();
		user.setName(registerRequest.getName());
		user.setEmail(registerRequest.getEmail());
		user.setPasswordHash(registerRequest.getPassword());
		user.setPhone(registerRequest.getPhone());
		user.setAccountType(registerRequest.getAccountType());		 user.setAddress(registerRequest.getAddress());
		user.setAddress(registerRequest.getAddress());
	        user.setCity(registerRequest.getCity());
	       
	        user.setStatus("ACTIVE");
	        
	        userRepo.save(user);
	        
		 return "Registration Successfull";
	}

	@Override
	public String logIn(LoginDTO loginRequest) {
		User user=userRepo.findByEmail(loginRequest.getEmail()).orElseThrow(()->new ResourceNotFoundException("User not found"));
		
		if(!user.getPasswordHash().equals(loginRequest.getPassword())){
			throw new ResourceNotFoundException("Invalid Password");
		}
		return "Login Successfull";
	}

	
}
