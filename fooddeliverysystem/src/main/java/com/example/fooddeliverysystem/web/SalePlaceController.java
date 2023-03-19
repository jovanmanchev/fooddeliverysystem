package com.example.fooddeliverysystem.web;

import com.example.fooddeliverysystem.exceptions.FoodItemNotFoundException;
import com.example.fooddeliverysystem.exceptions.SalePlaceNotFoundException;
import com.example.fooddeliverysystem.model.*;
import com.example.fooddeliverysystem.model.objects.FoodItemsWithQuantity;
import com.example.fooddeliverysystem.repository.PriceRepository;
import com.example.fooddeliverysystem.repository.storedprocedure.OrderCostCalcualte;
import com.example.fooddeliverysystem.service.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class SalePlaceController {

    private final OrderCostCalcualte orderCostCalcualte;

    private final SalePlaceService salePlaceService;
    private final PriceService priceService;
    private final OrderService orderService;
    private final HasFoodService hasFoodService;
    private final FoodItemService foodItemService;


    public SalePlaceController(SalePlaceService salePlaceService, PriceService priceService, OrderService orderService, HasFoodService hasFoodService,
                               FoodItemService foodItemService, OrderCostCalcualte orderCostCalcualte) {
        this.salePlaceService = salePlaceService;
        this.priceService = priceService;
        this.orderService = orderService;
        this.hasFoodService = hasFoodService;
        this.foodItemService = foodItemService;
        this.orderCostCalcualte = orderCostCalcualte;
    }

    @GetMapping("/salePlaces")
    public String showSalePlaces(Model model) {
        List<SalePlace> salePlaceList = this.salePlaceService.findAll();
        model.addAttribute("salePlaces", salePlaceList);

        return "saleplaces";
    }

    @GetMapping("/salePlace/{id}")
    public String showSalePlaceFooItems(@PathVariable Long id, Model model) {
        try {
            model.addAttribute("foodItems", this.salePlaceService.findSalePlaceServiceById(id).getFoodItemList());
            model.addAttribute("salePlaceId", id);
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
        } catch (SalePlaceNotFoundException salePlaceNotFoundException) {
            model.addAttribute("error", salePlaceNotFoundException.getMessage());
        }
        return "saleplacefooditems";
    }

    @PostMapping("/salePlace/{id}")
    public String createOrderInSalePlace(@PathVariable Long id,
                                         @RequestParam List<Long> foodIds,
                                         @RequestParam List<Integer> foodPrice,
                                         @RequestParam List<Integer> quantity,
                                         @RequestParam String typeOfPayment,
                                         HttpServletRequest httpServletRequest) {
        try {
            this.orderService.placeOrder(typeOfPayment, id, foodIds, foodPrice, quantity, httpServletRequest.getRemoteUser());

        } catch (SalePlaceNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/checkOrderStatus";
    }

    @GetMapping("/salePlace/Orders")
    public String showSalePlaceOrders(Model model, HttpServletRequest httpServletRequest) {

        Map<Long, List<FoodItem>> map = new HashMap<>();
        String username = httpServletRequest.getRemoteUser();
        try {
            List<Order> orders = this.salePlaceService.findAllCreatedOrders(username).stream().sorted(Comparator.comparingLong(Order::getOrderId)).collect(Collectors.toList());
            List<OrderHasFood> orderHasFoodList = new ArrayList<>();
            model.addAttribute("orders", orders);
            List<List<OrderHasFood>> outer = new ArrayList<>();
            for (Order order : orders) {
                List<OrderHasFood> inner = this.hasFoodService.findAllFoodsInOrder(order.getOrderId());
                outer.add(inner);
                List<FoodItem> items = new ArrayList<>();
                for (OrderHasFood orderHasFood : inner) {
                    FoodItem foodItems = this.salePlaceService.findSalePlaceServiceById(this.salePlaceService.findSalePlaceForUser(username).getSalePalceId())
                            .getFoodItemList()
                            .stream().filter(foodItem -> foodItem.getFoodItemId().equals(orderHasFood.getOrderHasFoodKey().getFoodItemId()))
                            .findFirst().get();
                    items.add(foodItems);

                }
                map.put(order.getOrderId(), items);
                model.addAttribute("quantity", outer);
            }

            model.addAttribute("orderHasFoods", map);

        } catch (SalePlaceNotFoundException e) {
            model.addAttribute("error", "sale place not found");
        }
        return "saleplaceorders";

    }

    @GetMapping("/changeOrderStatus/{id}")
    public String changeOrderStauts(@PathVariable Long id) {
        this.orderService.changeOrderStatus(id, "spremna");
        return "redirect:/salePlace/Orders";
    }

    @GetMapping("/checkOrderStatus")
    public String showOrderStatusToUser(HttpServletRequest httpServletRequest, Model model) {
        String username = httpServletRequest.getRemoteUser();
        List<Order> orders = this.orderService.findAllOrdersForCustomer(username);
        model.addAttribute("orders", orders.stream().sorted((a,b) -> Long.compare(b.getOrderId(), a.getOrderId())).collect(Collectors.toList()));
        Map<Long, List<FoodItemsWithQuantity>> foodNamesInOrder = new HashMap<>();
        for(Order order: orders){
            foodNamesInOrder.put(order.getOrderId(), this.hasFoodService.findAllFoodnamesInOrder(order.getOrderId()));
        }

        model.addAttribute("foodNames", foodNamesInOrder);
        return "showOrderStatusCustomer";
    }

    @GetMapping("/home")
    public String showHomePage() {

        return "home";
    }
    @GetMapping("/")
    public String showHome() {
        return "home";
    }
}
