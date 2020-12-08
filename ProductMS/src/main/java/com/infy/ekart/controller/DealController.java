package com.infy.ekart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.ekart.dto.ProductDTO;
import com.infy.ekart.service.DealInterface;

@RestController
public class DealController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	RestTemplate template;
	@Autowired
	DealInterface dealService;
	
	@GetMapping(value = "/deals",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> getDeals()
	{
		return ResponseEntity.ok(dealService.getDeals());
	}

}

