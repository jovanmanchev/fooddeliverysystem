package com.example.fooddeliverysystem.repository.viewsrepos;

import com.example.fooddeliverysystem.model.views.MostLoyalCustomerForEachPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MostLoyalCustomerForEachPlaceRepository extends JpaRepository<MostLoyalCustomerForEachPlace, Long> {
}
