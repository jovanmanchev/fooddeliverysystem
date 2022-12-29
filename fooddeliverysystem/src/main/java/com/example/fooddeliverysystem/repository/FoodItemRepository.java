package com.example.fooddeliverysystem.repository;

import com.example.fooddeliverysystem.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
}
