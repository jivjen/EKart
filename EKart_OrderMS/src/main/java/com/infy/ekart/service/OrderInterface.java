package com.infy.ekart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infy.ekart.dto.OrderDetails;
import com.infy.ekart.dto.ProductDTO;
import com.infy.ekart.exception.UserException;

@Service
public interface OrderInterface {
	
	List<ProductDTO> getRecommendations(String userId);
	
	ResponseEntity<Integer> place_order(String userId, String data) throws UserException;

	List<OrderDetails> getOrders(String userId);
	
	public String cancelOrder(String userId,int orderId);
	
}
