package com.infy.ekart.exception;

public enum ExceptionConstants {
	SERVER_ERROR("server.error"),

	
	
	
	
	ADDRESS_NOT_FOUND("address.not.found"),
	NO_CARDS("no.cards");
	
	

	private final String type;

	private ExceptionConstants(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type;
	}
}
