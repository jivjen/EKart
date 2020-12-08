package com.infy.ekart.exception;

public enum ExceptionConstants {
	SERVER_ERROR("server.error"),

	
	SELLER_NOT_FOUND("seller.not.found"),
	
	ADDRESS_NOT_FOUND("address.not.found"),
	NO_CARDS("no.cards"), 
	PRODUCT_NAME_ALREADY_EXISTS("product.name.already.exists");
	
	

	private final String type;

	private ExceptionConstants(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type;
	}
}
