package com.example.fooddeliverysystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

@Embeddable
public class PriceKey implements Serializable {

    @OneToOne(optional = false)
    @JoinColumn(name = "id_stavka", nullable = false)
    private FoodItem foodItem;

    @Column(name = "broj_cena", nullable = false)
    private Long priceNumber;


    public PriceKey(){

    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public Long getPriceNumber() {
        return priceNumber;
    }
}
