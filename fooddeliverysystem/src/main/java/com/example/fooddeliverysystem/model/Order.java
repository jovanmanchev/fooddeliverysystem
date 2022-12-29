package com.example.fooddeliverysystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "naracka")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "naracka_id")
    private Long orderId;

    @Column(name = "status")
    private String orderStatus;

    @Column(name = "datum_naracka")
    private Timestamp orderDate;

    @ManyToOne
    @JoinColumn(name = "dostavuvac_id")
    private Deliver deliver;

    @ManyToOne
    @JoinColumn(name = "id_mesto")
    private SalePlace salePlace;

    @ManyToOne
    @JoinColumn(name = "potrosuvac_id")
    private Consumer consumer;

    @ManyToOne
    @JoinColumn(name = "naplata_id")
    private OrderPayment orderPayment;



}
