package com.example.fooddeliverysystem.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "naplata")
public class OrderPayment {

    @Id
    @Column(name = "naplata_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderPaymentId;

    @Column(name = "iznos")
    private Integer orderCost;

    @Column(name = "nplakjanje")
    private String orderPaymentType;

    @Column(name = "datum_naplata")
    private Timestamp orderPaymentDate;

    @ManyToOne
    @JoinColumn(name = "potrosuvac_id")
    private Consumer consumer;

    @ManyToOne
    @JoinColumn(name = "dostavuvac_id")
    private Deliver deliver;

    public OrderPayment(Integer orderCost, String orderPaymentType, Timestamp orderPaymentDate, Consumer consumer, Deliver deliver) {
        this.orderCost = orderCost;
        this.orderPaymentType = orderPaymentType;
        this.orderPaymentDate = orderPaymentDate;
        this.consumer = consumer;
        this.deliver = deliver;
    }
    public OrderPayment(){

    }
}
