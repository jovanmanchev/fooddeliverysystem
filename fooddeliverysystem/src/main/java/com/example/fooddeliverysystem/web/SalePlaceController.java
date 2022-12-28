package com.example.fooddeliverysystem.web;

import com.example.fooddeliverysystem.model.SalePlace;
import com.example.fooddeliverysystem.repository.PriceRepository;
import com.example.fooddeliverysystem.service.PriceService;
import com.example.fooddeliverysystem.service.SalePlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SalePlaceController {

    private final SalePlaceService salePlaceService;
    private final PriceService priceService;
    public SalePlaceController(SalePlaceService salePlaceService, PriceService priceService) {
        this.salePlaceService = salePlaceService;
        this.priceService = priceService;
    }

    @GetMapping("/salePlaces")
    public String showSalePlaces(Model model){
        List<SalePlace> salePlaceList = this.salePlaceService.findAll();
        model.addAttribute("salePlaces", salePlaceList);

        return "saleplaces";
    }
}