package com.example.fooddeliverysystem.model;

import com.example.fooddeliverysystem.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vrabotenpd")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalePlaceEmployee {

    @Id
    @Column(name = "korisnik_id")
    private Long salePlaceEmployeeId;

    @ManyToOne
    @JoinColumn(name = "id_mesto")
    private SalePlace salePlace;


}
