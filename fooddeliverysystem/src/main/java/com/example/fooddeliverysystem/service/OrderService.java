package com.example.fooddeliverysystem.service;

import com.example.fooddeliverysystem.exceptions.SalePlaceNotFoundException;

import java.util.List;

public interface OrderService {

    void placeOrder(Long salePlaceId, List<Long> foodIds, List<Integer> foodPrices, List<Integer> foodQuantities, String username) throws SalePlaceNotFoundException;
}
