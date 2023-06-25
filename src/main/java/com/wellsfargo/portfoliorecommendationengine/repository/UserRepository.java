package com.wellsfargo.portfoliorecommendationengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.portfoliorecommendationengine.entity.User;

public interface UserRepository extends JpaRepository<User, Long>  {

}
