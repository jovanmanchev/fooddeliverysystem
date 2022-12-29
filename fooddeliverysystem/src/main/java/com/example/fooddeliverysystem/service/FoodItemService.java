package com.example.fooddeliverysystem.service;

import com.example.fooddeliverysystem.model.FoodItem;

import java.util.List;

public interface FoodItemService {

    List<FoodItem> findAllFoodItemsByIds(List<Long> foodItemIds);
}
