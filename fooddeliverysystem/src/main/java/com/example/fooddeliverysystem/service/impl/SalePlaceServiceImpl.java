package com.example.fooddeliverysystem.service.impl;

import com.example.fooddeliverysystem.model.SalePlace;
import com.example.fooddeliverysystem.repository.SalePlaceRepository;
import com.example.fooddeliverysystem.service.SalePlaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalePlaceServiceImpl implements SalePlaceService {

    private SalePlaceRepository salePlaceRepository;

    public SalePlaceServiceImpl(SalePlaceRepository salePlaceRepository) {
        this.salePlaceRepository = salePlaceRepository;
    }

    @Override
    public List<SalePlace> findAll() {
        return this.salePlaceRepository.findAll();
    }
}