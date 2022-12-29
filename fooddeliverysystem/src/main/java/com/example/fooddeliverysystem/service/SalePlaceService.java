package com.example.fooddeliverysystem.service;

import com.example.fooddeliverysystem.exceptions.SalePlaceNotFoundException;
import com.example.fooddeliverysystem.model.Order;
import com.example.fooddeliverysystem.model.SalePlace;

import java.util.List;

public interface SalePlaceService {

    List<SalePlace> findAll();
    SalePlace findSalePlaceServiceById(Long id) throws SalePlaceNotFoundException;

    List<Order> findAllCreatedOrders(String username) throws SalePlaceNotFoundException;
     SalePlace findSalePlaceForUser(String username);
}
