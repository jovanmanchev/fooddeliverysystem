package com.example.fooddeliverysystem.model;

import com.example.fooddeliverysystem.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "hrana")

@AllArgsConstructor
@NoArgsConstructor
public class FoodItem {

    @Id
    @Column(name = "id_stavka")
    private Long foodItemId;

    @Column(name = "ime_hra")
    private String foodItemName;

    @ManyToOne
    @JoinColumn(name = "vrabotenpd_id")
    private SalePlaceEmployee salePlaceEmployee;

    @ManyToOne
    @JoinColumn(name = "id_mesto")
    private SalePlace salePlace;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "hrana_e_napravena_namirnica",
    joinColumns = @JoinColumn(name = "id_stavka"),
    inverseJoinColumns = @JoinColumn(name = "id_namirnica"))
    private List<FoodStructure> foodStructures;

    public Long getFoodItemId() {
        return foodItemId;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public SalePlaceEmployee getSalePlaceEmployee() {
        return salePlaceEmployee;
    }

    public SalePlace getSalePlace() {
        return salePlace;
    }

    public List<FoodStructure> getFoodStructures() {
        return foodStructures;
    }
}
