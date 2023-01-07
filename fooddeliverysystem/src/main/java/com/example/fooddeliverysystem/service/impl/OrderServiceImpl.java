package com.example.fooddeliverysystem.service.impl;

import com.example.fooddeliverysystem.exceptions.FoodItemNotFoundException;
import com.example.fooddeliverysystem.exceptions.OrderNotFoundException;
import com.example.fooddeliverysystem.exceptions.SalePlaceNotFoundException;
import com.example.fooddeliverysystem.model.*;
import com.example.fooddeliverysystem.repository.*;
import com.example.fooddeliverysystem.service.OrderService;
import com.example.fooddeliverysystem.service.PriceService;
import com.example.fooddeliverysystem.service.SalePlaceService;
import com.example.fooddeliverysystem.service.UserService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final SalePlaceService salePlaceService;
    private final OrderRepository orderRepository;
    private final OrderHasFoodRepository orderHasFoodRepository;
    private final UserRepository userRepository;
    private final ConsumerRepository consumerRepository;

    private final FoodItemRepository foodItemRepository;
    private final DeliverRepository deliverRepository;
    private final PriceService priceService;
    public OrderServiceImpl(SalePlaceService salePlaceRepository, OrderRepository orderRepository, OrderHasFoodRepository orderHasFoodRepository, UserRepository userRepository,
                            ConsumerRepository consumerRepository, FoodItemRepository foodItemRepository, PriceService priceService, DeliverRepository deliverRepository) {
        this.salePlaceService = salePlaceRepository;
        this.orderRepository = orderRepository;
        this.orderHasFoodRepository = orderHasFoodRepository;
        this.userRepository = userRepository;
        this.consumerRepository = consumerRepository;
        this.foodItemRepository = foodItemRepository;
        this.priceService = priceService;
        this.deliverRepository = deliverRepository;
    }

    @Override
    public void placeOrder(String typeOfPayment, Long salePlaceId, List<Long> foodIds, List<Integer> foodPrices, List<Integer> foodQuantities, String username) throws SalePlaceNotFoundException {
        SalePlace salePlace = this.salePlaceService.findSalePlaceServiceById(salePlaceId);
        User user = this.userRepository.findByUsername(username).get();
        Consumer consumer = this.consumerRepository.findById(user.getUser_id()).get();

        Order order = new Order(typeOfPayment,"kreirana", Timestamp.valueOf(LocalDateTime.now()), salePlace ,consumer);
        List<OrderHasFood> orderHasFoodList = new ArrayList<>();
        order = orderRepository.save(order);
        for(int i = 0; i < foodIds.size(); i++){

            if(foodQuantities.get(i) != null) {
                OrderHasFood orderHasFood = new OrderHasFood(new OrderHasFoodKey(foodIds.get(i), order.getOrderId()), foodQuantities.get(i));
                orderHasFoodList.add(orderHasFood);
            }
        }
        this.orderHasFoodRepository.saveAll(orderHasFoodList);



    }

    @Override
    public Order changeOrderStatus(Long orderId, String status) {
        Order order = this.orderRepository.findById(orderId).get();
        order.setOrderStatus(status);

        return this.orderRepository.save(order);
    }

    @Override
    public Integer calculateCostOfOrder(Long orderId)  throws FoodItemNotFoundException {
        Integer totalCost = 0;
        List<OrderHasFood> orderHasFoodList = this.orderHasFoodRepository.findAllByOrderHasFoodKeyOrderId(orderId);
        for(OrderHasFood orderHasFood: orderHasFoodList){
            Long foodItemId = orderHasFood.getOrderHasFoodKey().getFoodItemId();
            FoodItem foodItem = this.foodItemRepository.findById(foodItemId).get();
            Integer quantity = orderHasFood.getQuantity();
            Integer price = this.priceService.findCurrentPriceForFoodItem(foodItem).getCost();
            totalCost += quantity * price;

        }

        return totalCost;
    }

    @Override
    public List<Order> findAllOrdersReadyToBeDelivered() {
        return this.orderRepository.findAllByOrderStatus("spremna");
    }

    @Override
    public List<Order> findAllOrdersForDeliver(String username) {
        User user = this.userRepository.findByUsername(username).get();
        Deliver deliver = this.deliverRepository.findById(user.getUser_id()).get();
        return this.orderRepository.findAllByOrderStatusAndDeliver("prevzemena", deliver);
    }

    @Override
    public Order updateOrderDeliver(String username, Long orderId) {
        User user = this.userRepository.findByUsername(username).get();
        Deliver deliver = this.deliverRepository.findById(user.getUser_id()).get();
        Order order = this.orderRepository.findById(orderId).get();
        order.setDeliver(deliver);
        return this.orderRepository.save(order);
    }

    @Override
    public Order findOrderById(Long orderId) throws OrderNotFoundException {
        return this.orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("order cannot be found"));
    }

    @Override
    public List<Order> findAllOrdersForCustomer(String username) {
        User user = this.userRepository.findByUsername(username).get();
        Consumer customer = this.consumerRepository.findById(user.getUser_id()).get();
        return this.orderRepository.findAllByConsumer(customer);
    }

    @Override
    public void saveOrder(Order order) {
        this.orderRepository.save(order);
    }
}
