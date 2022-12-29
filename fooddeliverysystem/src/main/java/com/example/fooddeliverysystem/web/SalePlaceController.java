package com.example.fooddeliverysystem.web;

import com.example.fooddeliverysystem.exceptions.FoodItemNotFoundException;
import com.example.fooddeliverysystem.exceptions.SalePlaceNotFoundException;
import com.example.fooddeliverysystem.model.Price;
import com.example.fooddeliverysystem.model.SalePlace;
import com.example.fooddeliverysystem.repository.PriceRepository;
import com.example.fooddeliverysystem.service.PriceService;
import com.example.fooddeliverysystem.service.SalePlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
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
    @GetMapping("/salePlace/{id}")
    public String showSalePlaceFooItems(@PathVariable Long id, Model model){
        try {
            model.addAttribute("foodItems", this.salePlaceService.findSalePlaceServiceById(id).getFoodItemList());
            List<Price> prices = new ArrayList<>();
            this.salePlaceService.findSalePlaceServiceById(id)
                    .getFoodItemList()
                    .forEach(foodItem -> {
                        try {
                            prices.add(this.priceService.findCurrentPriceForFoodItem(foodItem));
                        } catch (FoodItemNotFoundException e) {
                            model.addAttribute("foodItemError", e.getMessage());
                        }
                    });
            System.out.println(prices);

            model.addAttribute("prices", prices);
        }catch (SalePlaceNotFoundException salePlaceNotFoundException){
            model.addAttribute("error", salePlaceNotFoundException.getMessage());
        }
        return "saleplacefooditems";
    }
}
