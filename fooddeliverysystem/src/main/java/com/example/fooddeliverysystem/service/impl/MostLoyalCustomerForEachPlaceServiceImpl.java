package com.example.fooddeliverysystem.service.impl;

import com.example.fooddeliverysystem.model.views.MostLoyalCustomerForEachPlace;
import com.example.fooddeliverysystem.repository.viewsrepos.MostLoyalCustomerForEachPlaceRepository;
import com.example.fooddeliverysystem.service.MostLoyalCustomerForEachPlaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MostLoyalCustomerForEachPlaceServiceImpl implements MostLoyalCustomerForEachPlaceService {

    private final MostLoyalCustomerForEachPlaceRepository mostLoyalCustomerForEachPlaceRepository;

    public MostLoyalCustomerForEachPlaceServiceImpl(MostLoyalCustomerForEachPlaceRepository mostLoyalCustomerForEachPlaceRepository) {
        this.mostLoyalCustomerForEachPlaceRepository = mostLoyalCustomerForEachPlaceRepository;
    }

    @Override
    public List<MostLoyalCustomerForEachPlace> listAll() {
        return this.mostLoyalCustomerForEachPlaceRepository.findAll();
    }
}
