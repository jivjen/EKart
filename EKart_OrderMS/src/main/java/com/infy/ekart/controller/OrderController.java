package com.infy.ekart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.ekart.dto.CartDTO;
import com.infy.ekart.dto.OrderDetails;
import com.infy.ekart.dto.ProductDTO;
import com.infy.ekart.exception.UserException;
import com.infy.ekart.service.CheckoutService;
import com.infy.ekart.service.OrderInterface;



@RestController
public class OrderController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	RestTemplate template;
	@Autowired
	OrderInterface orderService;
	@Autowired
	CheckoutService checkoutService;
	@GetMapping(value="/{userId}/orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrderDetails>> getOrders(@PathVariable("userId") String userId)
	{
		logger.info("Get Orders Controller");
		
		return ResponseEntity.ok(orderService.getOrders(userId));
	}
	
	@GetMapping(value = "/{userId}/recommendations",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> getRecommendations(@PathVariable("userId")String userId)
	{
		logger.info("order required");
		
		return ResponseEntity.ok(orderService.getRecommendations(userId));
	}
	@GetMapping(value = "/recommendations",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getRecommendatios()
	{
		logger.info("order required");
		
		return ResponseEntity.ok("hello");
	}
	
	@PostMapping(value = "/{userid}/order/add", consumes = "application/json")
	public ResponseEntity<Integer> place_order(@PathVariable("userid") String userId, @RequestBody String data)
			throws UserException {
		ResponseEntity<Integer> order = orderService.place_order(userId, data);
		return order;
	}
	
	@GetMapping("{userId}/checkout")
	public ResponseEntity<CartDTO> checkOut(@PathVariable("userId") String userId){
		
		CartDTO cartDTO=checkoutService.getCartDetails(userId);
		
		return new ResponseEntity<CartDTO>(cartDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}/orders/{orderId}/cancel")
	public ResponseEntity<String> cancelOrder(@PathVariable String userId,@PathVariable int orderId)
	{
		String response=orderService.cancelOrder(userId,orderId);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	

}
