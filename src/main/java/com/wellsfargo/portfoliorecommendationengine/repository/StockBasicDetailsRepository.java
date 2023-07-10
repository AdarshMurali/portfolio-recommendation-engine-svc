package com.wellsfargo.portfoliorecommendationengine.repository;

import com.wellsfargo.portfoliorecommendationengine.entity.StockBasicDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockBasicDetailsRepository extends JpaRepository<StockBasicDetails, Integer > {

}
