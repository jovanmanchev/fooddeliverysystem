package com.example.fooddeliverysystem.service.impl;

import com.example.fooddeliverysystem.model.views.BestPacketsForEachSalePlace;
import com.example.fooddeliverysystem.repository.viewsrepos.BestPacketsForEachSalePlaceRepository;
import com.example.fooddeliverysystem.service.BestPacketsForEachSalePlaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BestPacketsForEachSalePlaceServiceImpl implements BestPacketsForEachSalePlaceService {

    private final BestPacketsForEachSalePlaceRepository bestPacketsForEachSalePlaceRepository;

    public BestPacketsForEachSalePlaceServiceImpl(BestPacketsForEachSalePlaceRepository bestPacketsForEachSalePlaceRepository) {
        this.bestPacketsForEachSalePlaceRepository = bestPacketsForEachSalePlaceRepository;
    }

    @Override
    public List<BestPacketsForEachSalePlace> listAll() {
        return this.bestPacketsForEachSalePlaceRepository.findAll();
    }
}
