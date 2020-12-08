package com.infy.ekart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.ekart.entity.WishListEntity;
import com.infy.ekart.service.WishListService;

@RestController
public class WishListController {

	@Autowired
	private WishListService service;
	
	
	@PostMapping("/{userId}/wishlist/{productId}/add")
	public ResponseEntity<Boolean> addToWish(@PathVariable String userId,@PathVariable Integer productId)
	{
		Boolean response;
		response=service.addToWish(userId,productId);
		return new ResponseEntity<Boolean>(response,HttpStatus.OK);
	}
	
	@PostMapping("/{userId}/wishlist/{productId}/remove")
	public ResponseEntity<Boolean> removeFromWish(@PathVariable String userId,@PathVariable Integer productId)
	{
		Boolean response;
		response=service.removeFromWish(userId,productId);
		return new ResponseEntity<Boolean>(response,HttpStatus.OK);
	}
	
	
}
