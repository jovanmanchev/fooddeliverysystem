package com.example.fooddeliverysystem.repository.viewsrepos;

import com.example.fooddeliverysystem.model.views.TotalCouponsByCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalCouponsByCustomerRepository extends JpaRepository<TotalCouponsByCustomer,Long> {
}
