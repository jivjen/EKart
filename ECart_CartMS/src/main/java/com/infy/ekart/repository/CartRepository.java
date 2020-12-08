package com.infy.ekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.ekart.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Integer> {

	CartEntity findByUserId(String userId);
	
	String findUserIdByCartId(int cartId);

}
