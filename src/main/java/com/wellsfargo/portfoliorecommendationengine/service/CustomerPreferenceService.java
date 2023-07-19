package com.wellsfargo.portfoliorecommendationengine.service;

import com.wellsfargo.portfoliorecommendationengine.entity.CustomerPreference;
import com.wellsfargo.portfoliorecommendationengine.entity.GetRecommendationRequest;
import com.wellsfargo.portfoliorecommendationengine.entity.GetRecommendationResponse;
import com.wellsfargo.portfoliorecommendationengine.repository.CustomerPreferenceRepository;
import com.wellsfargo.portfoliorecommendationengine.repository.UserRepository;
import com.wellsfargo.portfoliorecommendationengine.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerPreferenceService {

    @Autowired
    private CustomerPreferenceRepository customerPreferenceRepository;

    public CustomerPreference savePreference(CustomerPreference customerPreference) {
        CustomerPreference savedCustomerPreference = customerPreferenceRepository.save(customerPreference);
        return savedCustomerPreference;
    }

    public GetRecommendationResponse getRecommendation(GetRecommendationRequest getRecommendationRequest) {
//        GetRecommendationResponse recommendationResponse = new GetRecommendationResponse();
//        return recommendationResponse;
        return SecurityUtil.getRecommendationResponse();
    }
}
