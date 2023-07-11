package com.wellsfargo.portfoliorecommendationengine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name="Clients")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name="User_Id", nullable=false)
	private Long userid;

	@Column(name="First_Name", nullable=false)
	private String firstname;

	@Column(name="Last_Name", nullable=false)
	private String lastname;

	@Column(name="Email", nullable=false)
	private String email;

	@Column(name="Password", nullable=false)
	private String password;

}
