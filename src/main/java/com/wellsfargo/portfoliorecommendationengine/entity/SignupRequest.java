package com.wellsfargo.portfoliorecommendationengine.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
	
	private String firstname;
	private String lastname;
	private String email;
	private String password;

}
