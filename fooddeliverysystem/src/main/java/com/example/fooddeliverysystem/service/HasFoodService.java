package com.example.fooddeliverysystem.service;

import com.example.fooddeliverysystem.model.OrderHasFood;

import java.util.List;

public interface HasFoodService {
    List<OrderHasFood> findAllFoodsInOrder(Long orderId);

    List<String> findAllFoodnamesInOrder(Long orderId);
}
