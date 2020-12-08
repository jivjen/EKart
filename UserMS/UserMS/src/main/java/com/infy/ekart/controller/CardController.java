package com.infy.ekart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.ekart.dto.CardDTO;
import com.infy.ekart.entity.CardEntity;
import com.infy.ekart.exception.UserException;
import com.infy.ekart.service.CardService;

@RestController
public class CardController {

	
	@Autowired
	
	CardService cardService;
	
	
	//get card details
	@GetMapping("/{userId}/cards")
	public ResponseEntity<List<CardDTO>> getAllCardDetails(@PathVariable("userId") String userId) throws UserException{
		
		List<CardDTO> list=cardService.getAllCardDetails(userId);
		
		return ResponseEntity.ok(list);
	}
	
	//add card
	@PostMapping("/{userId}/card/add")
	public CardDTO addCardDetails(String userId,CardDTO cardDTO) throws UserException{
		CardDTO card = cardService.addCard(userId, cardDTO);
		
		return card;
	}
	
	
	//delete cards
	@DeleteMapping("/{userId}/card/{cardNumber}/delete")
	public ResponseEntity<String> deleteCardDetails (@PathVariable("userId") String userId, @PathVariable("cardNumber") Long cardNumber) throws UserException{
	CardDTO cardDTO=cardService.deleteCardDetails(userId,cardNumber);
	
	return ResponseEntity.ok("Card Detais Deleted Successfully");
	}
}
