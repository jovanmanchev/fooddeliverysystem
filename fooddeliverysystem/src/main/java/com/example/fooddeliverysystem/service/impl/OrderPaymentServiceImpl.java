package com.example.fooddeliverysystem.service.impl;

import com.example.fooddeliverysystem.exceptions.FoodItemNotFoundException;
import com.example.fooddeliverysystem.exceptions.OrderNotFoundException;
import com.example.fooddeliverysystem.model.Consumer;
import com.example.fooddeliverysystem.model.Deliver;
import com.example.fooddeliverysystem.model.Order;
import com.example.fooddeliverysystem.model.OrderPayment;
import com.example.fooddeliverysystem.repository.OrderPaymentRepository;
import com.example.fooddeliverysystem.service.OrderPaymentService;
import com.example.fooddeliverysystem.service.OrderService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class OrderPaymentServiceImpl implements OrderPaymentService {

    private final OrderService orderService;
    private final OrderPaymentRepository orderPaymentRepository;

    public OrderPaymentServiceImpl(OrderService orderService, OrderPaymentRepository orderPaymentRepository) {
        this.orderService = orderService;
        this.orderPaymentRepository = orderPaymentRepository;
    }



    @Override
    public void createOrderPayment(Long orderId) throws OrderNotFoundException, FoodItemNotFoundException {
      Order order = this.orderService.findOrderById(orderId);
      Integer orderCost = this.orderService.calculateCostOfOrder(orderId);
      Deliver deliver = order.getDeliver();
      Consumer consumer = order.getConsumer();
      OrderPayment orderPayment = new OrderPayment(orderCost, order.getTypeOfPayment(), Timestamp.valueOf(LocalDateTime.now()), consumer, deliver);
      order.setOrderStatus("zavrsena");
      OrderPayment orderPayment1 = this.orderPaymentRepository.save(orderPayment);
      Order order1 = this.orderService.findOrderById(orderId);
      order1.setOrderPayment(orderPayment1);
      this.orderService.saveOrder(order1);
    }
}
