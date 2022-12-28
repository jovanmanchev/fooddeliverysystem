package com.example.fooddeliverysystem.repository;

import com.example.fooddeliverysystem.model.SalePlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalePlaceRepository extends JpaRepository<SalePlace, Long> {
}
