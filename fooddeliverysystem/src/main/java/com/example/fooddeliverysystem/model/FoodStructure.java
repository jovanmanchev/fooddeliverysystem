package com.example.fooddeliverysystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "namirnica")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodStructure {

    @Id
    @Column(name = "id_namirnica")
    private Long foodStructureId;

    @Column(name = "ime_name")
    private String foodStructureName;

    @Column(name = "dali_alergent")
    private Boolean isAllergen;

}
