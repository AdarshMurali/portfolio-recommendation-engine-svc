package com.wellsfargo.portfoliorecommendationengine.controller;

import com.wellsfargo.portfoliorecommendationengine.entity.CustomerPreference;
import com.wellsfargo.portfoliorecommendationengine.entity.GetRecommendationRequest;
import com.wellsfargo.portfoliorecommendationengine.entity.GetRecommendationResponse;
import com.wellsfargo.portfoliorecommendationengine.entity.SignupRequest;
import com.wellsfargo.portfoliorecommendationengine.entity.SignupResponse;
import com.wellsfargo.portfoliorecommendationengine.service.CustomerPreferenceService;
import com.wellsfargo.portfoliorecommendationengine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/CustomerPreference")
public class CustomerPreferenceController {

    @Autowired
    private CustomerPreferenceService customerPreferenceService;

    @CrossOrigin
    @PostMapping("/savePreference")
    public ResponseEntity<CustomerPreference> savePreference(@RequestBody CustomerPreference customerPreference) {
        CustomerPreference savedPreference = customerPreferenceService.savePreference(customerPreference);
        return new ResponseEntity<>(savedPreference, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello "+Math.random(), HttpStatus.OK);
    }


    @CrossOrigin
    @PostMapping("/getDashboardData")
    public ResponseEntity<GetRecommendationResponse> getDashboardData(@RequestBody GetRecommendationRequest getRecommendationRequest) {
        GetRecommendationResponse recommendationResponse = customerPreferenceService.getDashboardData(getRecommendationRequest);
        return new ResponseEntity<>(recommendationResponse, HttpStatus.OK);
    }



}
