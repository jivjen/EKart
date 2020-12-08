package com.infy.ekart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.ekart.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
	
	Optional<UserEntity> findByUserId(String userId);
}
