package com.example.fooddeliverysystem.web;

import com.example.fooddeliverysystem.service.BestPacketsForEachSalePlaceService;
import com.example.fooddeliverysystem.service.MostLoyalCustomerForEachPlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportsController {

    private final BestPacketsForEachSalePlaceService bestPacketsForEachSalePlaceService;
    private final MostLoyalCustomerForEachPlaceService mostLoyalCustomerForEachPlaceService;
    public ReportsController(BestPacketsForEachSalePlaceService bestPacketsForEachSalePlaceService, MostLoyalCustomerForEachPlaceService mostLoyalCustomerForEachPlaceService) {
        this.bestPacketsForEachSalePlaceService = bestPacketsForEachSalePlaceService;
        this.mostLoyalCustomerForEachPlaceService = mostLoyalCustomerForEachPlaceService;
    }

    @GetMapping("/reports/bestPacketsEachSalePlace")
    public String getBestPacketsEachSalePlace(Model model){
        model.addAttribute("report", this.bestPacketsForEachSalePlaceService.listAll());
        return "reportsBestPacketsEachSalePlace";
    }
    @GetMapping("/reports/mostLoyalCustomerForEachPlace")
    public String getMostLoyalCustomerForEachPlace(Model model){
        model.addAttribute("report", this.mostLoyalCustomerForEachPlaceService.listAll());
        return "reportsMostLoyalCustomerForEachPlace";
    }
}
