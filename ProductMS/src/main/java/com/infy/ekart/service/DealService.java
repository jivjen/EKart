package com.infy.ekart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.ekart.dto.ProductDTO;
import com.infy.ekart.entity.DealEntity;
import com.infy.ekart.entity.ProductEntity;
import com.infy.ekart.repository.DealRepository;
import com.infy.ekart.repository.ProductRepository;

@Service
public class DealService implements DealInterface {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	DealRepository dealRepository;
	@Autowired
	ProductRepository productRepository;
	@Override
	public List<ProductDTO> getDeals() {
		
	List<DealEntity> dealEntities = dealRepository.findAll();
	List<ProductDTO> productDTOs = new ArrayList<>();
	for(DealEntity dealEntity:dealEntities)
	{
		Optional<ProductEntity> productEntityOptional = productRepository.findByProductId(dealEntity.getProductId());
		if(productEntityOptional.isPresent())
		{
			ProductEntity productEntity = productEntityOptional.get();
			ProductDTO productDTO = new ProductDTO();
			productDTO.setDiscount(dealEntity.getDiscount());
			productDTO.setDisplayName(productEntity.getDisplayName());
			productDTO.setShortDesc(productEntity.getShortDesc());
			productDTO.setCategory(productEntity.getCategory());
			productDTO.setPrice(productEntity.getPrice());
			productDTO.setProductId(productEntity.getProductId());
			productDTOs.add(productDTO);
		}
	}
	
	
	return productDTOs;
		
		
	}

}
