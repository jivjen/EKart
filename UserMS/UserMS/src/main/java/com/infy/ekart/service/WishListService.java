package com.infy.ekart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.ekart.entity.WishListEntity;
import com.infy.ekart.repository.WishListRepository;

@Service
public class WishListService {

	@Autowired
	private WishListRepository repo;
	

	public boolean addToWish(String userId,Integer productId)
	{
		WishListEntity wish=new WishListEntity();
		wish.setUserId(userId);
		wish.setProductId(productId);
		repo.saveAndFlush(wish);
		return true;
	
	}
	public boolean removeFromWish(String userId,Integer productId)
	{
		WishListEntity wish=repo.findByUserIdAndProductId(userId,productId);
		repo.delete(wish);
		return true;
		
	}
}

