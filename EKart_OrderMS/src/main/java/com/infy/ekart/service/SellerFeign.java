package com.infy.ekart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infy.ekart.dto.SellerDTO;

@FeignClient("EKartSellerMS")
public interface SellerFeign {

	@RequestMapping("/sellerDetails/{sellerId}")
	public SellerDTO getSellerDetails(@PathVariable("sellerId") String sellerId);
	
}
