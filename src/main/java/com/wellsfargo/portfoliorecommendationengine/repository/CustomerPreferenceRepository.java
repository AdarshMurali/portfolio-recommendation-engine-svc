package com.wellsfargo.portfoliorecommendationengine.repository;

import com.wellsfargo.portfoliorecommendationengine.entity.CustomerPreference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerPreferenceRepository extends JpaRepository<CustomerPreference, Long> {
    List<CustomerPreference> findByUserId(Long userId);
}
