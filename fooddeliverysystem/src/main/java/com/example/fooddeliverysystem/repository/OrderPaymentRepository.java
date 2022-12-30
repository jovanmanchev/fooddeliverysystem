package com.example.fooddeliverysystem.repository;

import com.example.fooddeliverysystem.model.OrderPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPaymentRepository extends JpaRepository<OrderPayment, Long> {
}
