package com.example.fooddeliverysystem.web;

import com.example.fooddeliverysystem.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class ReportsController {

    private final BestPacketsForEachSalePlaceService bestPacketsForEachSalePlaceService;
    private final MostLoyalCustomerForEachPlaceService mostLoyalCustomerForEachPlaceService;

    private final FranchizeEarningsBySalePlaceService franchizeEarningsBySalePlaceService;

    private final DeliverNumberOfOrdersDeliveredBySalePlaceService deliverNumberOfOrdersDeliveredBySalePlaceService;

    private final TotalCouponsByCustomerService totalCouponsByCustomerService;
    public ReportsController(BestPacketsForEachSalePlaceService bestPacketsForEachSalePlaceService,
                             MostLoyalCustomerForEachPlaceService mostLoyalCustomerForEachPlaceService,
                             FranchizeEarningsBySalePlaceService franchizeEarningsBySalePlaceService,
                             DeliverNumberOfOrdersDeliveredBySalePlaceService deliverNumberOfOrdersDeliveredBySalePlaceService,
                             TotalCouponsByCustomerService totalCouponsByCustomerService) {
        this.bestPacketsForEachSalePlaceService = bestPacketsForEachSalePlaceService;
        this.mostLoyalCustomerForEachPlaceService = mostLoyalCustomerForEachPlaceService;
        this.franchizeEarningsBySalePlaceService = franchizeEarningsBySalePlaceService;
        this.deliverNumberOfOrdersDeliveredBySalePlaceService = deliverNumberOfOrdersDeliveredBySalePlaceService;
        this.totalCouponsByCustomerService = totalCouponsByCustomerService;
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
        Set s = new HashSet(this.deliverNumberOfOrdersDeliveredBySalePlaceService.listAll());
        model.addAttribute("report", s);
        return "reportsDeliverNumberOfOrdersDeliveredBySalePlace";
    }

    @GetMapping("/reports/TotalCouponsByCustomer")
    public String getTotalCouponsByCustomer(Model model){
        model.addAttribute("report", this.totalCouponsByCustomerService.listAll());
        return "reportsTotalCouponsByCustomer";
    }
}
