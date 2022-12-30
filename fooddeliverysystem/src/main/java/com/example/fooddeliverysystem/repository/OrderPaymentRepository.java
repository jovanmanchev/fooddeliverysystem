package com.example.fooddeliverysystem.repository;

import com.example.fooddeliverysystem.model.OrderPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPaymentRepository extends JpaRepository<OrderPayment, Long> {
}
