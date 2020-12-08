package com.infy.ekart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.ekart.dto.CardDTO;

@Entity
@Table(name="card")
public class CardEntity {
	
	@Id
	@Column(name = "card_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer cardId;
	
	@Column(name = "user_id")
	private String userId;
	
	
	@Column(unique=true,name = "card_number")
	private Long cardNumber;
	
	@Column(name = "name_on_card")
	private String nameOnCard;
	
	@Column(name = "expiry_month")
	private Integer expiryMonth;
	
	@Column(name = "expiry_year")
	private Integer expiryYear;

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public Integer getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(Integer expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public Integer getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(Integer expiryYear) {
		this.expiryYear = expiryYear;
	}

	
	public CardEntity(Integer cardId, String userId, Long cardNumber, String nameOnCard, Integer expiryMonth,
			Integer expiryYear) {
		super();
		this.cardId = cardId;
		this.userId = userId;
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
	}
	
	
	public CardEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static CardEntity createCardEntity(CardDTO cardDTO) {
		
		CardEntity cardEntity=new CardEntity(cardDTO.getCardId(),
											cardDTO.getUserId(),
											cardDTO.getCardNumber(),
											cardDTO.getNameOnCard(),
											cardDTO.getExpiryMonth(),
											cardDTO.getExpiryYear());
		
				
		return cardEntity;
	}
	
	
	public static CardDTO createCardDTO(CardEntity cardEntity) {
		
		CardDTO cardDTO =new CardDTO(cardEntity.getCardId(),
										cardEntity.getUserId(),
										cardEntity.getCardNumber(), 
										cardEntity.getNameOnCard(), 
										cardEntity.getExpiryMonth(), 
										cardEntity.getExpiryYear());
		
		
		return cardDTO;
	}
	
	
}
