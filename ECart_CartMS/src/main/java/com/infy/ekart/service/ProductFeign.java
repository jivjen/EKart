package com.infy.ekart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infy.ekart.dto.ProductDTO;

@FeignClient("ProductMS")
public interface ProductFeign {

	@RequestMapping("/products/{productId}")
	public ProductDTO getProductDetails(@PathVariable("productId") int productId);
	
	
}
