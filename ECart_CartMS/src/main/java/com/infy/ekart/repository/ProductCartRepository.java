package com.infy.ekart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.ekart.dto.ProductCartDTO;
import com.infy.ekart.entity.ProductCartEntity;

public interface ProductCartRepository extends JpaRepository<ProductCartEntity, Integer>{

	List<ProductCartEntity> findByCartId(int cartId);
	
	Optional<ProductCartEntity> findByCartIdAndProductId(int cartId, int productId);
	
	List<ProductCartDTO> findByProductId(int productId);

}
