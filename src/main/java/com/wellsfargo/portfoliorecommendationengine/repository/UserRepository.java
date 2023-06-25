package com.wellsfargo.portfoliorecommendationengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.portfoliorecommendationengine.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>  {

    Optional<User> findByEmail(String email);
}
