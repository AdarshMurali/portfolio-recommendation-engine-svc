package com.wellsfargo.portfoliorecommendationengine.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private @Id @GeneratedValue Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;

}
