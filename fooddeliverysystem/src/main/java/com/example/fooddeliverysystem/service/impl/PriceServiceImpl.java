package com.example.fooddeliverysystem.service.impl;

import com.example.fooddeliverysystem.exceptions.FoodItemNotFoundException;
import com.example.fooddeliverysystem.model.FoodItem;
import com.example.fooddeliverysystem.model.Price;
import com.example.fooddeliverysystem.repository.PriceRepository;
import com.example.fooddeliverysystem.service.PriceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public List<Price> findAllPrices() {
        return this.priceRepository.findAll();
    }

    @Override
    public Price findCurrentPriceForFoodItem(FoodItem foodItem) throws FoodItemNotFoundException {
        List<Price> pricesForFoodItem = this.priceRepository.findAllByPriceKey_FoodItem(foodItem);
        Optional<Price> currentPrice = pricesForFoodItem.stream()
                .sorted((price1, price2) -> (int) (price2.getPriceKey().getPriceNumber() - price1.getPriceKey().getPriceNumber()))
                .findFirst();
        return currentPrice.orElseThrow(() -> new FoodItemNotFoundException("food item cannot be found"));

    }
}
