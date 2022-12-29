package com.example.fooddeliverysystem.repository.storedprocedure;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class OrderCostCalcualte {

    @PersistenceContext
    private EntityManager em;

    @Procedure
    public Integer calculate_cost_of_order_food(Long orderId){
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("calculate_cost_of_order_food2");
        query = query.setParameter("order_id", Integer.valueOf(String.valueOf(orderId)));
        query.execute();
       // System.out.println(query.getOutputParameterValue("vkupno_cena_hrana"));
        return null;
    }
}
