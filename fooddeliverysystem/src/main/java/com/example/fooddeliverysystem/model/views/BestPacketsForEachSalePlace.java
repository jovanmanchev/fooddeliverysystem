package com.example.fooddeliverysystem.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity(name = "najdobri_paketi_za_sekoe_prodazno_mesto")
@Immutable
@Data
@NoArgsConstructor
public class BestPacketsForEachSalePlace {


    @Column(name = "ime")
    private String namePlace;

    @Id
    @Column(name = "paket_id")
    private Long packetId;

    @Column(name = "se_sostoi_od")
    private String contains;

    @Column(name = "vkupno_prodadeni")
    private Integer totalSold;

    @Column(name = "ime_vraboten")
    private String employeeThatAddedName;
}
