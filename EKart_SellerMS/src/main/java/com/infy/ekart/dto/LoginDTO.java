package com.infy.ekart.dto;

public class LoginDTO {

	private String sellerId;
	private String password;
	
	public LoginDTO() {
		super();
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [sellerId=" + sellerId + ", password=" + password + "]";
	}
	

}
