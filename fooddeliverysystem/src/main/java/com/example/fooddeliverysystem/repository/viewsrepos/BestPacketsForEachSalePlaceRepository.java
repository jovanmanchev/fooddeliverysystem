package com.example.fooddeliverysystem.repository.viewsrepos;

import com.example.fooddeliverysystem.model.views.BestPacketsForEachSalePlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestPacketsForEachSalePlaceRepository extends JpaRepository<BestPacketsForEachSalePlace, Long> {
}
