package com.example.fooddeliverysystem.service.impl;

import com.example.fooddeliverysystem.model.OrderHasFood;
import com.example.fooddeliverysystem.repository.OrderHasFoodRepository;
import com.example.fooddeliverysystem.service.HasFoodService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HasFoodServiceImpl implements HasFoodService {


    private final OrderHasFoodRepository orderHasFoodRepository;

    public HasFoodServiceImpl(OrderHasFoodRepository orderHasFoodRepository) {
        this.orderHasFoodRepository = orderHasFoodRepository;
    }

    @Override
    public List<OrderHasFood> findAllFoodsInOrder(Long orderId) {
        return this.orderHasFoodRepository.findAllByOrderHasFoodKeyOrderId(orderId);
    }
}
