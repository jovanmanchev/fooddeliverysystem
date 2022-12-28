package com.example.fooddeliverysystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "cena")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Price {


   // @JoinColumn(name = "id_stavka", referencedColumnName = "id_stavka", nullable = false)
    //@ManyToOne
   // private FoodItem foodItem;

   // @Id
    //@Column(name = "broj_cena")
    //private Long priceNumber;

    @EmbeddedId
    private PriceKey priceKey;

    @Column(name = "iznos")
    private Integer cost;

    @Column(name = "vazi_od")
    private LocalDate validFrom;

    @Column(name = "vazi_do")
    private LocalDate validTo;
}
