package com.example.fooddeliverysystem.service.impl;

import com.example.fooddeliverysystem.model.views.DeliverNumberOfOrdersDeliveredBySalePlace;
import com.example.fooddeliverysystem.repository.viewsrepos.DeliverNumberOfOrdersDeliveredBySalePlaceRepository;
import com.example.fooddeliverysystem.service.DeliverNumberOfOrdersDeliveredBySalePlaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliverNumberOfOrdersDeliveredBySalePlaceServiceImpl implements DeliverNumberOfOrdersDeliveredBySalePlaceService {

    private final DeliverNumberOfOrdersDeliveredBySalePlaceRepository deliverNumberOfOrdersDeliveredBySalePlaceRepository;

    public DeliverNumberOfOrdersDeliveredBySalePlaceServiceImpl(DeliverNumberOfOrdersDeliveredBySalePlaceRepository deliverNumberOfOrdersDeliveredBySalePlaceRepository) {
        this.deliverNumberOfOrdersDeliveredBySalePlaceRepository = deliverNumberOfOrdersDeliveredBySalePlaceRepository;
    }

    @Override
    public List<DeliverNumberOfOrdersDeliveredBySalePlace> listAll() {
        return this.deliverNumberOfOrdersDeliveredBySalePlaceRepository.findAll();
    }
}
