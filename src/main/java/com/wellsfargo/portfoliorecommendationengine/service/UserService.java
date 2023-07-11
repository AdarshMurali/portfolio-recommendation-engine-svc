package com.wellsfargo.portfoliorecommendationengine.service;

import com.wellsfargo.portfoliorecommendationengine.entity.LoginRequest;
import com.wellsfargo.portfoliorecommendationengine.entity.LoginResponse;
import com.wellsfargo.portfoliorecommendationengine.entity.User;
import com.wellsfargo.portfoliorecommendationengine.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.portfoliorecommendationengine.entity.SignupRequest;
import com.wellsfargo.portfoliorecommendationengine.entity.SignupResponse;
import com.wellsfargo.portfoliorecommendationengine.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;


	public SignupResponse newUser(SignupRequest newUser) {
		SignupResponse signupResponse = new SignupResponse();
		User user = new User();
		user.setFirstname(newUser.getFirstname());
		user.setLastname(newUser.getLastname());
		user.setEmail(newUser.getEmail());
		user.setPassword(newUser.getPassword());
		User savedUser = userRepository.save(user);
		signupResponse.setUser(savedUser);
		return signupResponse;
	}

	public LoginResponse login(LoginRequest loginRequest) {
		LoginResponse loginResponse = new LoginResponse();
		Optional<User> savedUserOptional = userRepository.findByEmail(loginRequest.getEmail());
		if(!savedUserOptional.isPresent()){
			throw new UserNotFoundException("User not found with email "+loginRequest.getEmail());
		}else{
			User savedUser = savedUserOptional.get();
			if(loginRequest.getEmail().equals(savedUser.getEmail()) && loginRequest.getPassword().equals(savedUser.getPassword())){
				loginResponse.setUser(savedUser);
			}else{
				loginResponse.setUser(new User());
			}
		}
		return loginResponse;
	}
}
