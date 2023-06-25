package com.wellsfargo.portfoliorecommendationengine.service;

import com.wellsfargo.portfoliorecommendationengine.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.portfoliorecommendationengine.entity.SignupRequest;
import com.wellsfargo.portfoliorecommendationengine.entity.SignupResponse;
import com.wellsfargo.portfoliorecommendationengine.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;


	public SignupResponse newUser(SignupRequest newUser) {
		// TODO Auto-generated method stub
		
		SignupResponse signupResponse = new SignupResponse();
		User user = new User();
		user.setId(1L);
		signupResponse.setUser(user);
		return signupResponse;
	}

}
