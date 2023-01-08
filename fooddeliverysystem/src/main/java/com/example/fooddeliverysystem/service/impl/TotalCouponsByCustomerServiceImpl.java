package com.example.fooddeliverysystem.service.impl;

import com.example.fooddeliverysystem.model.views.TotalCouponsByCustomer;
import com.example.fooddeliverysystem.repository.viewsrepos.TotalCouponsByCustomerRepository;
import com.example.fooddeliverysystem.service.TotalCouponsByCustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TotalCouponsByCustomerServiceImpl implements TotalCouponsByCustomerService {

    private  final TotalCouponsByCustomerRepository totalCouponsByCustomerRepository;

    public TotalCouponsByCustomerServiceImpl(TotalCouponsByCustomerRepository totalCouponsByCustomerRepository) {
        this.totalCouponsByCustomerRepository = totalCouponsByCustomerRepository;
    }

    @Override
    public List<TotalCouponsByCustomer> listAll() {
        return this.totalCouponsByCustomerRepository.findAll();
    }
}
