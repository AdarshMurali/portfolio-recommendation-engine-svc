package com.wellsfargo.portfoliorecommendationengine.service;

import com.wellsfargo.portfoliorecommendationengine.entity.LoginRequest;
import com.wellsfargo.portfoliorecommendationengine.entity.LoginResponse;
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
		SignupResponse signupResponse = new SignupResponse();
		User user = new User();
		user.setId(1L);
		signupResponse.setUser(user);
		return signupResponse;
	}

	public LoginResponse login(LoginRequest loginRequest) {
		LoginResponse loginResponse = new LoginResponse();
		User user = new User();
		user.setId(1L);
		loginResponse.setUser(user);
		return loginResponse;
	}
}
