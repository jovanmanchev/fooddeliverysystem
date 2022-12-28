package com.example.fooddeliverysystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lokacija")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @Column(name = "lokacija_id")
    private Long locationId;


    @Column(name = "adresa")
    private String address;

    @Column(name = "broj")
    private Integer number;
}
