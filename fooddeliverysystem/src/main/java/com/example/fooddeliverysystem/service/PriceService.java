package com.example.fooddeliverysystem.service;

import com.example.fooddeliverysystem.exceptions.FoodItemNotFoundException;
import com.example.fooddeliverysystem.model.FoodItem;
import com.example.fooddeliverysystem.model.Price;

import java.util.List;

public interface PriceService {

    List<Price> findAllPrices();
    Price findCurrentPriceForFoodItem(FoodItem foodItem) throws FoodItemNotFoundException;
}
