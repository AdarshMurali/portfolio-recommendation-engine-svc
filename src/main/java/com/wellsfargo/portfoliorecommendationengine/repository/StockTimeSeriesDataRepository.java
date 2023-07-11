package com.wellsfargo.portfoliorecommendationengine.repository;

import com.wellsfargo.portfoliorecommendationengine.entity.StockTimeSeriesData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTimeSeriesDataRepository extends JpaRepository<StockTimeSeriesData, Integer> {
}
