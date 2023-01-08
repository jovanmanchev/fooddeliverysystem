package com.example.fooddeliverysystem.repository.viewsrepos;

import com.example.fooddeliverysystem.model.views.DeliverNumberOfOrdersDeliveredBySalePlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverNumberOfOrdersDeliveredBySalePlaceRepository extends JpaRepository<DeliverNumberOfOrdersDeliveredBySalePlace, Long> {
}
