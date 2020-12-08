package com.infy.ekart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.ekart.entity.DealEntity;
public interface DealRepository extends JpaRepository<DealEntity, Integer> {
	List<DealEntity> findByProductId(int productId);

}
