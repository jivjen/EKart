package com.infy.ekart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.infy.ekart.dto.CardDTO;
import com.infy.ekart.entity.CardEntity;
import com.infy.ekart.exception.ExceptionConstants;
import com.infy.ekart.exception.UserException;
import com.infy.ekart.repository.CardRepository;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class CardServiceImpl implements CardService {

	
	@Autowired
	private CardRepository cardRepository;
	
	@Override
	public List<CardDTO> getAllCardDetails(String userId) throws UserException{
		
		
		List<CardEntity> list=new ArrayList<>();
		
		list=cardRepository.findByUserId(userId);
		
		if(null==list || list.isEmpty()) {
			
			throw new UserException("No cards saved for you");
		}
		
		List<CardDTO> dtoList=new ArrayList<CardDTO>();
		
		for(CardEntity cardEntity:list) {
			
			dtoList.add(CardEntity.createCardDTO(cardEntity));
		}
		
		return dtoList;
	}

	@Override
	public CardDTO deleteCardDetails(String userId, Long cardNumber) throws UserException {
		// TODO Auto-generated method stub
		
		CardEntity cardEntity=cardRepository.findByUserIdAndCardNumber(userId,cardNumber);
		
		if(null==cardEntity) {
			throw new UserException("No card found for given details");
		}
		try {
			cardRepository.delete(cardEntity);
			
		} catch (Exception e) {
			throw new UserException("Error Occured "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public CardDTO addCard(String userId, CardDTO cardDTO) {
		
		cardDTO.setUserId(userId);
		
		return CardEntity.createCardDTO(cardRepository.saveAndFlush(CardEntity.createCardEntity(cardDTO)));
	}

}
