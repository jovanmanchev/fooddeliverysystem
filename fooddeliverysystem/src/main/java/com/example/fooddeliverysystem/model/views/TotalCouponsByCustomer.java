package com.example.fooddeliverysystem.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity(name = "potrosuvaci_vkupen_iznos_kuponi")
@Immutable
@Data
@NoArgsConstructor
public class TotalCouponsByCustomer {

    @Id
    @Column(name = "korisnik_id")
    private Long userId;

    @Column(name = "ime")
    private String userName;

    @Column(name = "vkupen_iznos")
    private Integer totalSum;
}
