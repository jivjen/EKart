package com.infy.ekart.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.ekart.dto.LoginDTO;
import com.infy.ekart.dto.SellerDetails;
import com.infy.ekart.dto.SellerReviewDTO;
import com.infy.ekart.entity.SellerEntity;
import com.infy.ekart.exception.EKartException;
import com.infy.ekart.exception.UserException;
import com.infy.ekart.service.SellerService;



@RestController
public class SellerController{
	
	@Autowired
	private SellerService sellerService;
	
	@PostMapping(value = "/product/add", consumes="application/json")
	public ResponseEntity<String> add_product(@RequestBody String data, String sellerId) throws UserException {
		return sellerService.add_product(data, sellerId);
	}
	@PostMapping("/adddetails")
	public ResponseEntity<String> pp(@RequestBody SellerEntity s) {
		    String response;
		    //logger.info("Inside loginCoach() method of {}", this.getClass());
			response=sellerService.pp(s);
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}
	
	@PostMapping("/login/seller")
	public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDto) throws EKartException{
		    String response;
		    //logger.info("Inside loginCoach() method of {}", this.getClass());
			response=sellerService.loginUser(loginDto);
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}
	
	@PostMapping("/{sellerId}/review")
	public ResponseEntity<String> giveReview(@RequestBody SellerReviewDTO dto ,@PathVariable String sellerId)
	{
		dto.setSellerId(sellerId);
		LocalDate date=LocalDate.now();
		dto.setDateOfReview(date);
		return new ResponseEntity<String>(sellerService.giveReview(dto,sellerId),HttpStatus.OK);
	}
	
	@GetMapping("/sellerDetails/{sellerId}")
	public ResponseEntity<SellerDetails> getSeller(@PathVariable("sellerId") String sellerId)
	{
		return ResponseEntity.ok(sellerService.getSeller(sellerId));
	}
}
