package com.example.fooddeliverysystem.model;

import com.example.fooddeliverysystem.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dostavuvac")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deliver {

    @Id
    @Column(name = "korisnik_id")
    private Long delivererId;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "vozilo_id")
    private Vehicle vehicle;



}
