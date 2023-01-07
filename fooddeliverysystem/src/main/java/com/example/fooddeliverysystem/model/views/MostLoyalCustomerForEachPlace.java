package com.example.fooddeliverysystem.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity(name = "najveren_potrosuvac_za_sekoe_prodazno_mesto")
@Immutable
@Data
@NoArgsConstructor
public class MostLoyalCustomerForEachPlace {

    @Column(name = "ime_potrosuvac")
    private String customerName;

    @Column(name = "ime_mesto")
    private String salePlaceName;

    @Column(name = "adresa_potrosuvac")
    private String customerAdress;

    @Column(name = "broj_adresa_potrosuvac")
    private Integer customerAdressNumber;

    @Id
    @Column(name = "broj_naracka")
    private Long orderNumber;



}
