package com.infy.ekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.ekart.entity.SellerEntity;

public interface SellerRepository extends JpaRepository<SellerEntity, String> {

}
