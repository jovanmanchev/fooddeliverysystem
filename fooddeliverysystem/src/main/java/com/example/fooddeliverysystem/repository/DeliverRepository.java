package com.example.fooddeliverysystem.repository;

import com.example.fooddeliverysystem.model.Deliver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverRepository extends JpaRepository<Deliver, Long> {
}
