package com.wellsfargo.portfoliorecommendationengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.portfoliorecommendationengine.entity.SignupRequest;
import com.wellsfargo.portfoliorecommendationengine.entity.SignupResponse;
import com.wellsfargo.portfoliorecommendationengine.service.UserService;

@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@CrossOrigin
	@PostMapping("/signup")
	public ResponseEntity<SignupResponse> newUser(@RequestBody SignupRequest newUser) {
	    SignupResponse signupResponse = userService.newUser(newUser);
	    return new ResponseEntity<>(signupResponse, HttpStatus.OK);
	  }

}
