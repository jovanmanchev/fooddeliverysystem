package com.example.fooddeliverysystem.service;

import com.example.fooddeliverysystem.exceptions.UserNotFoundException;
import com.example.fooddeliverysystem.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    UserDetails loadUserByUsername(String username);
}
