package com.infy.ekart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.ekart.entity.WishListEntity;

public interface WishListRepository extends JpaRepository<WishListEntity,String> {

	
	WishListEntity findByUserIdAndProductId(String userId,Integer productId);
}
