package com.infy.ekart.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.ekart.entity.CardEntity;

public interface CardRepository extends JpaRepository<CardEntity, Integer> {

	public List<CardEntity> findByUserId(String userId);

	public CardEntity findByUserIdAndCardNumber(String userId, Long cardNumber);
	
}
