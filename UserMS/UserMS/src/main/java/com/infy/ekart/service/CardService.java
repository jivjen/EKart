package com.infy.ekart.service;

import java.util.List;

import com.infy.ekart.dto.CardDTO;
import com.infy.ekart.exception.UserException;

public interface CardService {

	List<CardDTO> getAllCardDetails(String userId)throws UserException;

	CardDTO deleteCardDetails(String userId, Long cardNumber) throws UserException;

	CardDTO addCard(String userId, CardDTO cardDTO);

}
