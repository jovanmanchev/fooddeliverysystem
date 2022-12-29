package com.example.fooddeliverysystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "prodazhnomesto")

@NoArgsConstructor
@AllArgsConstructor
public class SalePlace {
    @Id
    @Column(name = "id_mesto")
    private Long salePalceId;

    @Column(name = "ime")
    private String salePlaceName;

    @Column(name = "ulica")
    private String salePlaceStreetName;

    @Column(name = "broj")
    private Integer salePlaceStreetNumber;

    @ManyToOne
    @JoinColumn(name = "franshiza_id")
    private Franchize franchize;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany(mappedBy = "salePlace", fetch = FetchType.EAGER)
    List<FoodItem> foodItemList;

    public Long getSalePalceId() {
        return salePalceId;
    }

    public String getSalePlaceName() {
        return salePlaceName;
    }

    public String getSalePlaceStreetName() {
        return salePlaceStreetName;
    }

    public Integer getSalePlaceStreetNumber() {
        return salePlaceStreetNumber;
    }

    public Franchize getFranchize() {
        return franchize;
    }

    public Admin getAdmin() {
        return admin;
    }

    public List<FoodItem> getFoodItemList() {
        return foodItemList;
    }
}

