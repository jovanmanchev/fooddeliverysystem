package com.example.fooddeliverysystem.repository;

import com.example.fooddeliverysystem.model.SalePlaceEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalePlaceEmployeeRepository extends JpaRepository<SalePlaceEmployee, Long> {
}
