package com.example.fooddeliverysystem.web;

import com.example.fooddeliverysystem.service.BestPacketsForEachSalePlaceService;
import com.example.fooddeliverysystem.service.DeliverNumberOfOrdersDeliveredBySalePlaceService;
import com.example.fooddeliverysystem.service.FranchizeEarningsBySalePlaceService;
import com.example.fooddeliverysystem.service.MostLoyalCustomerForEachPlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportsController {

    private final BestPacketsForEachSalePlaceService bestPacketsForEachSalePlaceService;
    private final MostLoyalCustomerForEachPlaceService mostLoyalCustomerForEachPlaceService;

    private final FranchizeEarningsBySalePlaceService franchizeEarningsBySalePlaceService;

    private final DeliverNumberOfOrdersDeliveredBySalePlaceService deliverNumberOfOrdersDeliveredBySalePlaceService;
    public ReportsController(BestPacketsForEachSalePlaceService bestPacketsForEachSalePlaceService,
                             MostLoyalCustomerForEachPlaceService mostLoyalCustomerForEachPlaceService,
                             FranchizeEarningsBySalePlaceService franchizeEarningsBySalePlaceService,
                             DeliverNumberOfOrdersDeliveredBySalePlaceService deliverNumberOfOrdersDeliveredBySalePlaceService) {
        this.bestPacketsForEachSalePlaceService = bestPacketsForEachSalePlaceService;
        this.mostLoyalCustomerForEachPlaceService = mostLoyalCustomerForEachPlaceService;
        this.franchizeEarningsBySalePlaceService = franchizeEarningsBySalePlaceService;
        this.deliverNumberOfOrdersDeliveredBySalePlaceService = deliverNumberOfOrdersDeliveredBySalePlaceService;
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
    @GetMapping("/reports/franchizeEarningsBySalePlace")
    public String getFranchizeEarningsBySalePlace(Model model){
        model.addAttribute("report", this.franchizeEarningsBySalePlaceService.listAll());
        return "reportsFranchizeEarningsBySalePlace";
    }

    @GetMapping("/reports/DeliverNumberOfOrdersDeliveredBySalePlace")
    public String getDeliverNumberOfOrdersDeliveredBySalePlace(Model model){
        model.addAttribute("report", this.deliverNumberOfOrdersDeliveredBySalePlaceService.listAll());
        return "reportsDeliverNumberOfOrdersDeliveredBySalePlace";
    }
}
