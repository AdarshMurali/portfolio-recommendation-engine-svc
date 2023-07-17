package com.wellsfargo.portfoliorecommendationengine.utils;

import com.wellsfargo.portfoliorecommendationengine.entity.GetRecommendationResponse;
import com.wellsfargo.portfoliorecommendationengine.entity.RecommendedSecurities;

import java.util.ArrayList;
import java.util.List;

public class SecurityUtil {

    public static GetRecommendationResponse getRecommendationResponse(){
        GetRecommendationResponse getRecommendationResponse = new GetRecommendationResponse();
        List<RecommendedSecurities> recommendedSecurities = new ArrayList<>();

        RecommendedSecurities r1 = new RecommendedSecurities("MMM", "3M Company", "reports", "Industrials", "Industrial Conglomerates", "", "St. Paul, Minnesota", "66740" );
        RecommendedSecurities r2 = new RecommendedSecurities("MMM", "3M Company", "reports", "Industrials", "Industrial Conglomerates", "", "St. Paul, Minnesota", "66740" );
        RecommendedSecurities r3 = new RecommendedSecurities("MMM", "3M Company", "reports", "Industrials", "Industrial Conglomerates", "", "St. Paul, Minnesota", "66740" );

        recommendedSecurities.add(r1);
        recommendedSecurities.add(r2);
        recommendedSecurities.add(r3);
        getRecommendationResponse.setRecommendedSecurities(recommendedSecurities);
        return getRecommendationResponse;
    }
}
