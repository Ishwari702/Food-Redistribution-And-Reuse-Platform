package com.food.DTO;

import com.food.entities.Role;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
private String name;
private String email;
private String password;
private String phone;
private String accountType;
private String address;
private String city;
}
