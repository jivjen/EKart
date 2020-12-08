package com.infy.ekart.service;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.ekart.dto.LoginDTO;
import com.infy.ekart.dto.ProductDTO;
import com.infy.ekart.dto.SellerDTO;
import com.infy.ekart.dto.SellerDetails;
import com.infy.ekart.dto.SellerProductDTO;
import com.infy.ekart.dto.SellerReviewDTO;
import com.infy.ekart.entity.SellerEntity;
import com.infy.ekart.entity.SellerProductsEntity;
import com.infy.ekart.entity.SellerReviewsEntity;
import com.infy.ekart.exception.EKartException;
import com.infy.ekart.exception.ExceptionConstants;
import com.infy.ekart.exception.UserException;
import com.infy.ekart.repository.SellerProductsRepository;
import com.infy.ekart.repository.SellerRepository;
import com.infy.ekart.repository.SellerReviewsRepository;

@Service
public class SellerService {
	
	@Autowired
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private SellerProductsRepository sellerProductRepository;
	
	@Autowired
	SellerReviewsRepository repo;
	
	@Autowired 
	SellerRepository repo1;
	
	public String pp(SellerEntity s)
	{
		repo1.saveAndFlush(s);
		return "ok";
	}
	

	public ResponseEntity<String> add_product(String data, String sellerId) throws UserException {
		RestTemplate restTemplate = new RestTemplate();

		JSONObject product = new JSONObject(data);

		// Product
		SellerProductDTO sellerProductDTO = new SellerProductDTO();

		// check if productname exists
		String sellerProductName;

		ProductDTO productDTO = restTemplate.getForObject(
				"http://localhost:5000/searchproduct/" + product.getString("displayName"), ProductDTO.class);
		if (productDTO == null) {
			sellerProductName = product.getString("displayName");
		} else {
			throw new UserException(ExceptionConstants.PRODUCT_NAME_ALREADY_EXISTS.toString());
		}

		//Creation of Product DTO
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<>(product.toString(), headers);
		String result = restTemplate.postForObject("http://localhost:5000/addproduct/", request, String.class); // changing
		productDTO = restTemplate.getForObject(
				"http://localhost:5000/searchproduct/" + product.getString("displayName"), ProductDTO.class);

		JSONObject obj = new JSONObject(data);
		double deliveryCharge = obj.getDouble("deliveryCharge");

		// new SellerProductDTO
		sellerProductDTO.setSellerId(sellerId);
		sellerProductDTO.setProductId(productDTO.getProductId());
		sellerProductDTO.setDeliveryCharge(deliveryCharge);

		SellerProductsEntity sellerProductEntity = sellerProductDTO.createSellerProductEntity();
		sellerProductRepository.save(sellerProductEntity);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	public String giveReview(SellerReviewDTO dto, String sellerId) {
		
		SellerReviewsEntity s=SellerReviewDTO.changeToEntity(dto);
		repo.saveAndFlush(s);
		return "yes";
		
	}
	
	public String loginUser(LoginDTO loginDto) throws EKartException {
		String response="";
		System.out.println(loginDto.toString());
		Optional<SellerEntity> seller=repo1.findById(loginDto.getSellerId());
		System.out.println(seller.toString());
		if(seller.isPresent())
		{
			if(loginDto.getPassword().equals(seller.get().getPassword()))
			{
				
				return "User logged in succesfully";
			}
			
			response = ExceptionConstants.SELLER_NOT_FOUND.toString();
			throw new EKartException(response);
		}
		response = ExceptionConstants.SELLER_NOT_FOUND.toString();
		
		throw new EKartException(response);
	}


	public SellerDetails getSeller(String sellerId) {
		Optional<SellerEntity> seller =  repo1.findById(sellerId);
		SellerDetails sellerDetails = new SellerDetails();
		sellerDetails.setSellerId(seller.get().getSellerId());
		sellerDetails.setName(seller.get().getName());
		return sellerDetails;
		
	}

}
