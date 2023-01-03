package com.example.fooddeliverysystem.web;


import com.example.fooddeliverysystem.exceptions.FoodItemNotFoundException;
import com.example.fooddeliverysystem.exceptions.OrderNotFoundException;
import com.example.fooddeliverysystem.model.Order;
import com.example.fooddeliverysystem.service.OrderPaymentService;
import com.example.fooddeliverysystem.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DeliveryController {

    private final OrderService orderService;

    private final OrderPaymentService orderPaymentService;
    public DeliveryController(OrderService orderService, OrderPaymentService orderPaymentService) {
        this.orderService = orderService;
        this.orderPaymentService = orderPaymentService;
    }

    @GetMapping("/deliveryOrders")
    public String showOrdersForDelivery(Model model){
        List<Integer> costs = new ArrayList<>();
        List<Order> orders = this.orderService.findAllOrdersReadyToBeDelivered();
        for(Order order: orders){
            try {
                costs.add(this.orderService.calculateCostOfOrder(order.getOrderId()));
            } catch (FoodItemNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        model.addAttribute("orders", orders);
        model.addAttribute("costs", costs);
        return "delivery";
    }

    @GetMapping("/takeOrder/{id}")
    public String deliverTakesOrder(@PathVariable Long id, HttpServletRequest httpServletRequest){
        this.orderService.changeOrderStatus(id, "prevzemena");
        this.orderService.updateOrderDeliver(httpServletRequest.getRemoteUser(), id);
        return "redirect:/showOrderDeliverer";
    }
    @GetMapping("/showOrderDeliverer")
    public String showDelivererAllOrders(Model model, HttpServletRequest httpServletRequest){
        List<Integer> costs = new ArrayList<>();
        List<Order> orders = this.orderService.findAllOrdersForDeliver(httpServletRequest.getRemoteUser());
        System.out.println(orders);
        for(Order order: orders){
            try {
                costs.add(this.orderService.calculateCostOfOrder(order.getOrderId()));
            } catch (FoodItemNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        model.addAttribute("orders", orders);
        model.addAttribute("costs", costs);
        return "ordersfordeliver";
    }
    @GetMapping("/orderPayment/{id}")
    public String markOrderAsPayed(@PathVariable Long id){
        try {
            this.orderPaymentService.createOrderPayment(id);
        } catch (OrderNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (FoodItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/showOrderDeliverer";
    }
}
