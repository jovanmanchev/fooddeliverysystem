package com.example.fooddeliverysystem.repository.viewsrepos;

import com.example.fooddeliverysystem.model.views.FranchizeEarningsBySalePlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchizeEarningsBySalePlaceRepository extends JpaRepository<FranchizeEarningsBySalePlace, String> {
}
