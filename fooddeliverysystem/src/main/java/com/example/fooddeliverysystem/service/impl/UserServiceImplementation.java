package com.example.fooddeliverysystem.service.impl;

import com.example.fooddeliverysystem.exceptions.UserNotFoundException;
import com.example.fooddeliverysystem.model.User;

import com.example.fooddeliverysystem.model.enums.Role;
import com.example.fooddeliverysystem.model.userssecurity.UserPrincipal;
import com.example.fooddeliverysystem.repository.*;
import com.example.fooddeliverysystem.service.UserService;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final ConsumerRepository consumerRepository;
    private final SalePlaceEmployeeRepository salePlaceEmployeeRepository;

    private final DeliverRepository deliverRepository;
    public UserServiceImplementation(UserRepository userRepository, AdminRepository adminRepository, ConsumerRepository consumerRepository, SalePlaceEmployeeRepository salePlaceEmployeeRepository,
                                     DeliverRepository deliverRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
        this.consumerRepository = consumerRepository;
        this.salePlaceEmployeeRepository = salePlaceEmployeeRepository;
        this.deliverRepository = deliverRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        Long id = user.getUser_id();
        if(this.adminRepository.findById(id).isPresent())
            user.setUserRole(Role.ADMIN);
        else if(this.consumerRepository.findById(id).isPresent())
            user.setUserRole(Role.CONSUMER);
        else if(this.deliverRepository.findById(id).isPresent())
            user.setUserRole(Role.DELIVER);
        else
            user.setUserRole(Role.SALEPLACEEMPLOYEE);
        return new UserPrincipal(user);
    }


}
