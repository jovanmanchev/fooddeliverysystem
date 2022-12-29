package com.example.fooddeliverysystem.service.impl;

import com.example.fooddeliverysystem.exceptions.SalePlaceNotFoundException;
import com.example.fooddeliverysystem.model.*;
import com.example.fooddeliverysystem.repository.*;
import com.example.fooddeliverysystem.service.OrderService;
import com.example.fooddeliverysystem.service.SalePlaceService;
import com.example.fooddeliverysystem.service.UserService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final SalePlaceService salePlaceService;
    private final OrderRepository orderRepository;
    private final OrderHasFoodRepository orderHasFoodRepository;
    private final UserRepository userRepository;
    private final ConsumerRepository consumerRepository;
    public OrderServiceImpl(SalePlaceService salePlaceRepository, OrderRepository orderRepository, OrderHasFoodRepository orderHasFoodRepository, UserRepository userRepository,
                            ConsumerRepository consumerRepository) {
        this.salePlaceService = salePlaceRepository;
        this.orderRepository = orderRepository;
        this.orderHasFoodRepository = orderHasFoodRepository;
        this.userRepository = userRepository;
        this.consumerRepository = consumerRepository;
    }

    @Override
    public void placeOrder(Long salePlaceId, List<Long> foodIds, List<Integer> foodPrices, List<Integer> foodQuantities, String username) throws SalePlaceNotFoundException {
        SalePlace salePlace = this.salePlaceService.findSalePlaceServiceById(salePlaceId);
        User user = this.userRepository.findByUsername(username).get();
        Consumer consumer = this.consumerRepository.findById(user.getUser_id()).get();
        Order order = new Order("kreirana", Timestamp.valueOf(LocalDateTime.now()), salePlace ,consumer);
        List<OrderHasFood> orderHasFoodList = new ArrayList<>();
        order = orderRepository.save(order);
        for(int i = 0; i < foodIds.size(); i++){
            OrderHasFood orderHasFood = new OrderHasFood(new OrderHasFoodKey(foodIds.get(i), order.getOrderId()), foodQuantities.get(i));
            orderHasFoodList.add(orderHasFood);
        }
        this.orderHasFoodRepository.saveAll(orderHasFoodList);



    }
}
