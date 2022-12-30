package com.example.fooddeliverysystem.service;

import com.example.fooddeliverysystem.exceptions.FoodItemNotFoundException;
import com.example.fooddeliverysystem.exceptions.OrderNotFoundException;

public interface OrderPaymentService {

    void createOrderPayment(Long orderId) throws OrderNotFoundException, FoodItemNotFoundException;
}
