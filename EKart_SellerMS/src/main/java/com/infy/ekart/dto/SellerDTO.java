package com.infy.ekart.dto;

public class SellerDTO {

	private String sellerId;
	private String name;
	private String password;
	private String email;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
	
	
}
