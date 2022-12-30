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
@NamedStoredProcedureQuery(
        name = "calculate_cost_of_order_food2",
        procedureName = "calculate_cost_of_order_food2",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "order_id")
        }
)
public class Order {

    @Id
    @Column(name = "naracka_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "nacinplakjanje")
    private String typeOfPayment;

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

    @Transient
    private Integer orderCost;
    public Order(String orderStatus, Timestamp orderDate, SalePlace salePlace, Consumer consumer) {
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.salePlace = salePlace;
        this.consumer = consumer;

    }

    public Order(String typeOfPayment, String orderStatus, Timestamp orderDate, SalePlace salePlace, Consumer consumer) {
        this.typeOfPayment = typeOfPayment;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.salePlace = salePlace;
        this.consumer = consumer;
    }
}
