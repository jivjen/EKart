package com.infy.ekart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.ekart.entity.ProductReview;

public interface ReviewRepository extends JpaRepository<ProductReview, Integer> {
	List<ProductReview> findByProductId(int ProductId);
	
}
