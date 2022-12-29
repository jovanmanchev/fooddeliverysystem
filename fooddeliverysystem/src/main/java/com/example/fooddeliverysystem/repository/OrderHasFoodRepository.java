package com.example.fooddeliverysystem.repository;

import com.example.fooddeliverysystem.model.OrderHasFood;
import com.example.fooddeliverysystem.model.OrderHasFoodKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHasFoodRepository extends JpaRepository<OrderHasFood, OrderHasFoodKey> {
}
