package com.example.fooddeliverysystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "naracka_sodrzi_hrana")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHasFood {

    @EmbeddedId
    private OrderHasFoodKey orderHasFoodKey;



    @Column(name = "kolicina")
    private Integer quantity;
}
