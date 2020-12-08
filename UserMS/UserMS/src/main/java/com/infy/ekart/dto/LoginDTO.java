package com.infy.ekart.dto;

public class LoginDTO {

	private String userId;
	private String password;
	
	public LoginDTO() {
		super();
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [userId=" + userId + ", password=" + password + "]";
	}
	

}
