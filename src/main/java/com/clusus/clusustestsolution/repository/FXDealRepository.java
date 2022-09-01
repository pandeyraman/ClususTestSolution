package com.clusus.clusustestsolution.repository;

import com.clusus.clusustestsolution.entity.FXDeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FXDealRepository extends JpaRepository<FXDeal, Long> {
}
