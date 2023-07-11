package com.wellsfargo.portfoliorecommendationengine.repository;

import com.wellsfargo.portfoliorecommendationengine.entity.CustomerPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerPreferenceRepository extends JpaRepository<CustomerPreference, Long> {
}
