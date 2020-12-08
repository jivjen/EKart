package com.infy.ekart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.ekart.dto.AddCartDTO;
import com.infy.ekart.dto.CartDetails;
import com.infy.ekart.dto.ProductCartDTO;
import com.infy.ekart.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartService cartService;

	@GetMapping("/{userId}/cart")
	public ResponseEntity<CartDetails> getCartDetails(@PathVariable("userId") String userId)
	{
		return ResponseEntity.ok(cartService.getCartDetails(userId));
	}
	
	@GetMapping("/{userId}/cartcount")
	public int getCartCount(@PathVariable("userId") String userId) {
		return cartService.getCartItemsCount(userId);
	}
	
	@GetMapping("/processCart/{userId}/{guestId}")
	public int processCart(@PathVariable("userId") String userId, @PathVariable("GuestId") String guestId)
	{
		return cartService.processCart(userId, guestId); 
	}
	
	@PostMapping(value = "/{userId}/modifycart",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> modifyCart(@PathVariable("userId")String userId,@Valid @RequestBody ProductCartDTO productCartDTO) {
		
		cartService.modifyCart(userId,productCartDTO);
		return ResponseEntity.ok("Cart updated successfully");
	}
	
	@GetMapping("/{productId}/getUsers")
    public List<String> findUserIdbyProductId(@PathVariable int productId){
    	return cartService.findUserIdbyProductId(productId);
    }

	@PostMapping(value = "/{userId}/addtocart",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addToCart(@PathVariable("userId")String userId,@Valid @RequestBody AddCartDTO addCartDTO) {
		
		cartService.addToCart(userId,addCartDTO);
		return ResponseEntity.ok("Product added successfully");
	}

	
	

	
}
