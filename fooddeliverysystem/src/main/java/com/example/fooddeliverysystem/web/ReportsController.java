package com.example.fooddeliverysystem.web;

import com.example.fooddeliverysystem.service.BestPacketsForEachSalePlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportsController {

    private final BestPacketsForEachSalePlaceService bestPacketsForEachSalePlaceService;

    public ReportsController(BestPacketsForEachSalePlaceService bestPacketsForEachSalePlaceService) {
        this.bestPacketsForEachSalePlaceService = bestPacketsForEachSalePlaceService;
    }

    @GetMapping("/reports/bestPacketsEachSalePlace")
    public String getBestPacketsEachSalePlace(Model model){
        model.addAttribute("report", this.bestPacketsForEachSalePlaceService.listAll());
        return "reportsBestPacketsEachSalePlace";
    }
}
