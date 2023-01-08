package com.example.fooddeliverysystem.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity(name = "dostavuvac_dostavi_za_sekoe_prod_mesto")
@Immutable
@Data
@NoArgsConstructor
public class DeliverNumberOfOrdersDeliveredBySalePlace {

    @Id
    @Column(name = "id_mesto")
    private Long salePlaceId;

    @Column(name = "ime")
    private String deliverName;

    @Column(name = "ime_mesto")
    private String salePlaceName;

    @Column(name = "broj_naracki")
    private Integer numberOfOrders;

    @Column(name = "vkupna_suma")
    private Integer totalSum;
}
