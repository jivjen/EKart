package com.infy.ekart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.infy.ekart.dto.ProductDTO;
import com.infy.ekart.exception.UserException;

public interface ProductInterface {

	List<ProductDTO> getProducts(String productName);

	ResponseEntity<String> add_new_product(String data) throws UserException;
	
	
	

	

	List<ProductDTO> getProducts(Integer[] ids);

	ProductDTO getProduct(int productId);

	List<ProductDTO> getAllProducts(Integer[] ids);

	List<Integer> Modify_catalog(String productName, String data) throws UserException;

	List<ProductDTO> View_Catalog(String sellerId) throws UserException;



}
