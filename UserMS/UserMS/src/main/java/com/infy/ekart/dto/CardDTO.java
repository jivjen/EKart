package com.infy.ekart.dto;

public class CardDTO {

	
	
	private Integer cardId;
	private String userId;
	private Long cardNumber;
	private String nameOnCard;
	private Integer expiryMonth;
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
	
	public CardDTO(Integer cardId, String userId, Long cardNumber, String nameOnCard, Integer expiryMonth,
			Integer expiryYear) {
		super();
		this.cardId = cardId;
		this.userId = userId;
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
	}
	public CardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
