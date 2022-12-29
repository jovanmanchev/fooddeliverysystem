package com.example.fooddeliverysystem.service.impl;

import com.example.fooddeliverysystem.exceptions.SalePlaceNotFoundException;
import com.example.fooddeliverysystem.model.Order;
import com.example.fooddeliverysystem.model.SalePlace;
import com.example.fooddeliverysystem.model.SalePlaceEmployee;
import com.example.fooddeliverysystem.model.User;
import com.example.fooddeliverysystem.repository.OrderRepository;
import com.example.fooddeliverysystem.repository.SalePlaceEmployeeRepository;
import com.example.fooddeliverysystem.repository.SalePlaceRepository;
import com.example.fooddeliverysystem.repository.UserRepository;
import com.example.fooddeliverysystem.service.SalePlaceService;
import com.example.fooddeliverysystem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalePlaceServiceImpl implements SalePlaceService {

    private SalePlaceRepository salePlaceRepository;
    private OrderRepository orderRepository;

    private UserRepository userRepository;
    private SalePlaceEmployeeRepository salePlaceEmployeeRepository;
    public SalePlaceServiceImpl(SalePlaceRepository salePlaceRepository, OrderRepository orderRepository, UserRepository userRepository,
                                SalePlaceEmployeeRepository salePlaceEmployeeRepository) {
        this.salePlaceRepository = salePlaceRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.salePlaceEmployeeRepository = salePlaceEmployeeRepository;
    }

    @Override
    public List<SalePlace> findAll() {
        return this.salePlaceRepository.findAll();
    }

    @Override
    public SalePlace findSalePlaceServiceById(Long id) throws SalePlaceNotFoundException {
        return this.salePlaceRepository.findById(id).orElseThrow(() -> new SalePlaceNotFoundException("Sale place not found"));

    }

    @Override
    public List<Order> findAllCreatedOrders(String username) throws SalePlaceNotFoundException{

        return this.orderRepository.findAllBySalePlaceAndOrderStatus(findSalePlaceForUser(username), "kreirana");
    }

    @Override
    public SalePlace findSalePlaceForUser(String username){
        User user = this.userRepository.findByUsername(username).get();

        SalePlaceEmployee salePlaceEmployee = this.salePlaceEmployeeRepository.findById(user.getUser_id()).get();
        return salePlaceEmployee.getSalePlace();
    }
}

