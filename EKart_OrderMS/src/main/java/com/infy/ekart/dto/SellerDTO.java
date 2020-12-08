package com.infy.ekart.dto;

public class SellerDTO {
	
	private String sellerId;
	private String name;
	public SellerDTO(String sellerId, String name) {
		super();
		this.sellerId = sellerId;
		this.name = name;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
