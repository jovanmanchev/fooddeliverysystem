package com.example.fooddeliverysystem.model;

import com.example.fooddeliverysystem.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "potrosuvac")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consumer {

    @Id
    @Column(name = "korisnik_id")
    private Long consumerId;

    @Column(name = "broj_naracki")
    private Integer numberOfOrders;

    @ManyToOne
    @JoinColumn(name = "lokacija_id")
    private Location location;


}
