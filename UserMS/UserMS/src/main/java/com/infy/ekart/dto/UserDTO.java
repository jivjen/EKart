package com.infy.ekart.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserDTO {
	private static final String patternString = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$";
	private static final String patternName = "^\\w+(\\s\\w+)*$";
	private String userId;
	@NotNull
	@Pattern(regexp = patternName,message ="Name should not have any special characters or numbers.")
	private String name;
	@Pattern(regexp = patternString,message = "Password must have one lowecase character,one uppercase character,one special character and a number.")
	private String password;
	@Email
	private String email;
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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

}
