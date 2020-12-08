package com.infy.ekart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infy.ekart.dto.SellerDTO;

@FeignClient("SellerMS")
public interface SellerFeign {

	@RequestMapping("/seller/{productId}")
	public SellerDTO getSellerDetails(@PathVariable("productId") int productId);
	
}
