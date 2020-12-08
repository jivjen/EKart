package com.infy.ekart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.ekart.entity.ProductEntity;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
	Optional<ProductEntity> findByProductId(int productId);
	List<ProductEntity> findByDisplayNameStartsWith(String displayName);
	List<ProductEntity> findByDisplayName(String prodName);
	List<ProductEntity> findByProductId(String productName);
}
