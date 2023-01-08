package com.example.fooddeliverysystem.service.impl;

import com.example.fooddeliverysystem.model.views.FranchizeEarningsBySalePlace;
import com.example.fooddeliverysystem.repository.viewsrepos.FranchizeEarningsBySalePlaceRepository;
import com.example.fooddeliverysystem.service.FranchizeEarningsBySalePlaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranchizeEarningsBySalePlaceServiceImpl implements FranchizeEarningsBySalePlaceService {


    private final FranchizeEarningsBySalePlaceRepository franchizeEarningsBySalePlaceRepository;

    public FranchizeEarningsBySalePlaceServiceImpl(FranchizeEarningsBySalePlaceRepository franchizeEarningsBySalePlaceRepository) {
        this.franchizeEarningsBySalePlaceRepository = franchizeEarningsBySalePlaceRepository;
    }

    @Override
    public List<FranchizeEarningsBySalePlace> listAll() {
        return this.franchizeEarningsBySalePlaceRepository.findAll();
    }
}
