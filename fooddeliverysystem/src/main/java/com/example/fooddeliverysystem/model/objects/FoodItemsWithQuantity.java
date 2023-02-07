package com.example.fooddeliverysystem.model.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemsWithQuantity{
    private String foodName;
    private Integer foodQuantity;
}