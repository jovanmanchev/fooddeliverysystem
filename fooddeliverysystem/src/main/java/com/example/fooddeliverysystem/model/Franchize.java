package com.example.fooddeliverysystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "franshiza")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Franchize {

    @Id
    @Column(name = "franshiza_id")
    private Long franchizeId;

    @Column(name = "ime")
    private String franchizeName;
}
