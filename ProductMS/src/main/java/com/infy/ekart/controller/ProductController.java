package com.infy.ekart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.ekart.dto.ProductDTO;
import com.infy.ekart.exception.UserException;
import com.infy.ekart.service.ProductInterface;

@RestController
public class ProductController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	RestTemplate template;
	@Autowired
	ProductInterface productService;
	
	@GetMapping(value = "/product",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> getProducts(@RequestParam Integer[] ids)
	{
		logger.info(ids.toString());
		return ResponseEntity.ok(productService.getProducts(ids));
	}
	
	@PostMapping(value = "/addproduct")
	public ResponseEntity<String> add_new_product(@RequestBody String data) throws UserException {
		return productService.add_new_product(data);
	}
	
	@GetMapping(value="/products/{productId}",produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> getProductById(@PathVariable("productId") int productId)
	{
		return ResponseEntity.ok(productService.getProduct(productId));

	}
	
	@GetMapping(value="/products")
	public ResponseEntity<List<ProductDTO>> getAllProducts(@RequestParam Integer[] ids)
	{
		logger.info(ids.toString());
		return ResponseEntity.ok(productService.getAllProducts(ids));
	}
	
	@GetMapping(value = "/searchproduct/{displayName}")
	public ResponseEntity<List<ProductDTO>> getProducts(@PathVariable("displayName") String productName) {
//		logger.info("GET request for products, inside getProducts() of", this.getClass());
		List<ProductDTO> products = productService.getProducts(productName);
		return ResponseEntity.ok(products);
	}

//	@GetMapping(value = "/{displayName}/details")
//	public ResponseEntity<ProductDTO> getProduct(@PathVariable("displayName") String productName) {
////		logger.info("GET request for product details, inside getProduct() of", this.getClass());
//		ProductDTO product = productService.getProduct(productName);
//		return ResponseEntity.ok(product);
//	}
//	
//	@PostMapping(value="/{userId}/addtocart")
//	public void addToCart(@RequestBody CartDTO cart, @PathVariable("userId") String userId ) {
//		productService.addToCart(cart, userId);
//		
//	}
	
	@GetMapping(value = "{sellerId}/products", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<ProductDTO>> View_Catalog(@PathVariable String sellerId) throws UserException {
		List<ProductDTO> productDTOs = productService.View_Catalog(sellerId);
		logger.info("Viewing Catalog for SellerId: " + sellerId);
		return new ResponseEntity<>(productDTOs, HttpStatus.OK);
	}

	@PutMapping(value = "product/{productname}/modify")
	public List<Integer> Modify_catalog(@PathVariable("productname") String productName, @RequestBody String data)
			throws UserException {
		List<Integer> productIds = productService.Modify_catalog(productName, data);
		logger.info("Modifying Catalog for productName: " + productName);
		return productIds;
	}
	
	
}
