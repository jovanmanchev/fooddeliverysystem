package com.example.fooddeliverysystem.service;

import com.example.fooddeliverysystem.exceptions.FoodItemNotFoundException;
import com.example.fooddeliverysystem.exceptions.OrderNotFoundException;
import com.example.fooddeliverysystem.exceptions.SalePlaceNotFoundException;
import com.example.fooddeliverysystem.model.Order;

import java.util.List;

public interface OrderService {

    void placeOrder(String typeOfPayment, Long salePlaceId, List<Long> foodIds, List<Integer> foodPrices, List<Integer> foodQuantities, String username) throws SalePlaceNotFoundException;

    Order changeOrderStatus(Long orderId, String status);

    Integer calculateCostOfOrder(Long orderId) throws FoodItemNotFoundException;
    List<Order> findAllOrdersReadyToBeDelivered();

    List<Order> findAllOrdersForDeliver(String username);

    Order updateOrderDeliver(String username, Long orderId);

    Order findOrderById(Long orderId) throws OrderNotFoundException;

    List<Order> findAllOrdersForCustomer(String username);

    void saveOrder(Order order);
}
