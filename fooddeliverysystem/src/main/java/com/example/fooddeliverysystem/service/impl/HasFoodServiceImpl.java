package com.example.fooddeliverysystem.service.impl;

import com.example.fooddeliverysystem.model.FoodItem;
import com.example.fooddeliverysystem.model.OrderHasFood;
import com.example.fooddeliverysystem.repository.FoodItemRepository;
import com.example.fooddeliverysystem.repository.OrderHasFoodRepository;
import com.example.fooddeliverysystem.service.FoodItemService;
import com.example.fooddeliverysystem.service.HasFoodService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HasFoodServiceImpl implements HasFoodService {


    private final OrderHasFoodRepository orderHasFoodRepository;
    private final FoodItemRepository foodItemRepository;
    public HasFoodServiceImpl(OrderHasFoodRepository orderHasFoodRepository, FoodItemRepository foodItemRepository) {
        this.orderHasFoodRepository = orderHasFoodRepository;
        this.foodItemRepository = foodItemRepository;
    }
    @Override
    public List<OrderHasFood> findAllFoodsInOrder(Long orderId) {
        return this.orderHasFoodRepository.findAllByOrderHasFoodKeyOrderId(orderId);
    }

    @Override
    public List<String> findAllFoodnamesInOrder(Long orderId) {
        List<String> foodNames = new ArrayList<>();

        List<OrderHasFood> orderHasFoodList = this.orderHasFoodRepository.findAll();
        for(OrderHasFood orderHasFood: orderHasFoodList){
            if(orderId.equals(orderHasFood.getOrderHasFoodKey().getOrderId())){
                FoodItem foodItem = this.foodItemRepository.findById(orderHasFood.getOrderHasFoodKey().getFoodItemId()).get();
                foodNames.add(foodItem.getFoodItemName());
            }


        }

        return foodNames;
    }
}
