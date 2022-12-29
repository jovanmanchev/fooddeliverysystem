package com.example.fooddeliverysystem.service.impl;

import com.example.fooddeliverysystem.model.FoodItem;
import com.example.fooddeliverysystem.repository.FoodItemRepository;
import com.example.fooddeliverysystem.service.FoodItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemServceImpl implements FoodItemService {

    private final FoodItemRepository foodItemRepository;

    public FoodItemServceImpl(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    @Override
    public List<FoodItem> findAllFoodItemsByIds(List<Long> foodItemIds) {
        return this.foodItemRepository.findAllById(foodItemIds);
    }

    @Override
    public FoodItem findFoodItemById(Long id) {
        return this.foodItemRepository.findById(id).get();
    }
}
