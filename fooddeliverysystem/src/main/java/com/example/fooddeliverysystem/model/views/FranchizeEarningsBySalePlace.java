package com.example.fooddeliverysystem.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity(name = "franshiza_promet_mesta_tri_meseci")
@Immutable
@Data
@NoArgsConstructor
public class FranchizeEarningsBySalePlace {

    @Id
    @Column(name = "ime_franshiza")
    private String franchizeName;

    @Column(name = "ime_prodaznomesto")
    private String salePlaceName;

    @Column(name = "vkupen_promet")
    private Integer totalSold;

}
