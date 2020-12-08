package com.infy.ekart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.ekart.dto.ProductDTO;
import com.infy.ekart.entity.ProductEntity;
import com.infy.ekart.exception.UserException;
import com.infy.ekart.repository.ProductRepository;

@Service
public class ProductService implements ProductInterface {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	RestTemplate template;
	@Autowired
	ProductRepository productRepository;
	@Override
	public List<ProductDTO> getProducts(Integer[] ids) {
		List<ProductDTO> productDTOs = new ArrayList<>();
		for(Integer id:ids)
		{
			Optional<ProductEntity> productEntity = productRepository.findByProductId(id);
			if(productEntity.isPresent())
			{
				productDTOs.add(ProductDTO.valueOf(productEntity.get()));
			}
		}
		return productDTOs;
	}
	
	
	@Override
	public ResponseEntity<String> add_new_product(String data) throws UserException {
		JSONObject obj = new JSONObject(data);
		double deliveryCharge = obj.getDouble("deliveryCharge");
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setDisplayName(obj.getString("displayName"));
		productDTO.setShortDesc(obj.getString("shortDesc"));
		productDTO.setDescription(obj.getString("description"));
		productDTO.setCategory(obj.getString("category"));
		productDTO.setPrice(obj.getFloat("price"));
		productDTO.setImageUrl(obj.getString("imageUrl"));
		ProductEntity productEntity = productDTO.createProductEntity();
		productRepository.save(productEntity);
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}


	
	@Override
	public ProductDTO getProduct(int productId) {
		Optional<ProductEntity> productEntity = productRepository.findByProductId(productId);
	 return ProductDTO.valueOf(productEntity.get());
	}


	@Override
	public List<ProductDTO> getProducts(String productName) {
		List<ProductDTO> productDTOs = new ArrayList<>();

			List<ProductEntity> productEntity = productRepository.findByProductId(productName);
			if(productEntity.size()>0)
			{
				for(ProductEntity p :  productEntity)
				productDTOs.add(ProductDTO.valueOf(p));
			}
		
		return productDTOs;
	}


	@Override
	public List<ProductDTO> getAllProducts(Integer[] ids) {
		List<ProductEntity> productEntity = productRepository.findAll();
		List<ProductDTO> products = new ArrayList<>();
		for(ProductEntity pro: productEntity)
		{
			products.add(ProductDTO.valueOf(pro));
		}
		return products;
	}


	@Override
	public List<ProductDTO> View_Catalog(String sellerId) throws UserException {
		RestTemplate restTemplate = new RestTemplate();

		List<ProductDTO> productDTOs = new ArrayList<>();

		List<Integer> productIds = restTemplate.getForObject("http://EKartSellerMS/" + sellerId + "/productIds",
				List.class); // 5003 -> 5004(ProductMS) getProductIds()
		for (Integer integer : productIds) {
			Optional<ProductEntity> productEntity = productRepository.findByProductId(integer);

				ProductDTO productDTO = new ProductDTO();
				productDTOs.add(productDTO.valueOf(productEntity.get()));
		
		}

		return productDTOs;
	}

	
	@Override
	public List<Integer> Modify_catalog(String productName, String data) throws UserException {
		JSONObject obj = new JSONObject(data);
		RestTemplate restTemplate = new RestTemplate();

		List<Integer> productIds = new ArrayList<>();
		List<String> userIds = new ArrayList<>();

		List<ProductEntity> productEntities = productRepository.findByDisplayName(productName);
		for (ProductEntity productEntity : productEntities) {
			productEntity.setPrice(obj.getFloat("price"));
			productRepository.saveAndFlush(productEntity);
			productIds.add(productEntity.getProductId());

			userIds = restTemplate.getForObject("http://localhost:/5001/" + productEntity.getProductId() + "/getUsers",
					List.class); // 5003 -> 5001(CartMS) getuserIds
			for (String userId : userIds) {
				JSONObject message = new JSONObject();
				message.accumulate("userId", userId);
				message.accumulate("message",
						"Price Change detected on " + productName + " and notified as this product is in the cart.");
				message.accumulate("messageType", "Price Change");

				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<String> request = new HttpEntity<>(message.toString(), headers);
				restTemplate.postForObject(
						"http://localhost:5005/" + productEntity.getProductId() + "/notifications/priceChange", request,
						null); // 5003 -> 5005(UserMS) price_Change_notification
			}
		}

		return productIds;
	}




}
