package com.wellsfargo.portfoliorecommendationengine.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetRecommendationResponse {

    private List<RecommendedSecurities> recommendedSecurities;
}
