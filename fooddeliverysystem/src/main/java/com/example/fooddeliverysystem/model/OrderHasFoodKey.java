package com.example.fooddeliverysystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderHasFoodKey implements Serializable {

    @Column(name = "id_stavka")
    private Long foodItemId;

    @Column(name = "naracka_id")
    private Long orderId;


}
