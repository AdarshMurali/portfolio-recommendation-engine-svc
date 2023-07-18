package com.wellsfargo.portfoliorecommendationengine.repository;

import com.wellsfargo.portfoliorecommendationengine.entity.StockTimeSeriesData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockTimeSeriesDataRepository extends JpaRepository<StockTimeSeriesData, Integer> {

    @Query("SELECT DISTINCT s.Symbol FROM StockTimeSeriesDetails s")
    List<String> getDistinctSymbol();
}
