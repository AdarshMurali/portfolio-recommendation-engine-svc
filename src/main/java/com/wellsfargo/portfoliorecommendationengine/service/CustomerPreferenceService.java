package com.wellsfargo.portfoliorecommendationengine.service;

import com.wellsfargo.portfoliorecommendationengine.entity.CustomerPreference;
import com.wellsfargo.portfoliorecommendationengine.entity.GetRecommendationRequest;
import com.wellsfargo.portfoliorecommendationengine.entity.GetRecommendationResponse;
import com.wellsfargo.portfoliorecommendationengine.repository.CustomerPreferenceRepository;
import com.wellsfargo.portfoliorecommendationengine.repository.UserRepository;
import com.wellsfargo.portfoliorecommendationengine.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerPreferenceService {

    @Autowired
    private CustomerPreferenceRepository customerPreferenceRepository;

    public CustomerPreference savePreference(CustomerPreference customerPreference) {
        CustomerPreference savedCustomerPreference = customerPreferenceRepository.save(customerPreference);
        return savedCustomerPreference;
    }


    public GetRecommendationResponse getDashboardData(GetRecommendationRequest getRecommendationRequest) {
        //        GetRecommendationResponse recommendationResponse = new GetRecommendationResponse();
//        return recommendationResponse;
        List<CustomerPreference> customerPreferenceList =  customerPreferenceRepository.findByUserId(getRecommendationRequest.getUserId());
        return SecurityUtil.getRecommendationResponse();
    }
}
