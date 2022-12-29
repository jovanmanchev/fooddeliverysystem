package com.example.fooddeliverysystem.repository;

import com.example.fooddeliverysystem.model.FoodItem;
import com.example.fooddeliverysystem.model.Price;
import com.example.fooddeliverysystem.model.PriceKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PriceRepository extends JpaRepository<Price, PriceKey> {
    List<Price> findAllByPriceKey_FoodItem(FoodItem foodItem);
}
