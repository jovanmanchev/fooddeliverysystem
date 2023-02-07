package com.example.fooddeliverysystem.service;

import com.example.fooddeliverysystem.model.OrderHasFood;
import com.example.fooddeliverysystem.model.objects.FoodItemsWithQuantity;

import java.util.List;

public interface HasFoodService {
    List<OrderHasFood> findAllFoodsInOrder(Long orderId);

    List<FoodItemsWithQuantity> findAllFoodnamesInOrder(Long orderId);
}
