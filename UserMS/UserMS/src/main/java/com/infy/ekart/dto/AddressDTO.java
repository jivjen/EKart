package com.infy.ekart.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AddressDTO {
	
	private int addressId;
	
	@NotBlank(message="{user.address.must}")
	private String address;
	
	@NotBlank(message="{user.city.must}")
	@Pattern(regexp="^[a-zA-Z_ ]*{3,20}$",message = "{user.address.city}")
	private String city;
	
	@NotBlank(message="{user.state.must}")
	private String state;
	
	@NotNull(message="{user.pin.must}")
	@Min(value=111111L, message= "{user.address.pin}")
	@Max(value=999999L, message= "{user.address.pin}")
	private int pincode;
	
	@NotNull(message="{user.phone.must}")
	@Min(value=111111L, message= "{user.phone}")
	@Max(value=999999L, message= "{user.phone}")
	private String phoneNumber;
	
	private String userId;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
