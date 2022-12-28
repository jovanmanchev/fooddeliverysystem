package com.example.fooddeliverysystem.model;

import com.example.fooddeliverysystem.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "korisnik")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "korisnik_id")
    private Long user_id;

    @Column(name = "ime")
    private String name;

    @Column(name = "datum_kreiranje")
    private LocalDate dateCreated;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    private Role userRole;
}
