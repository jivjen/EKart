package com.infy.ekart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.ekart.dto.AddressDTO;

@Entity
@Table(name="address")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;
	private String address;
	private String city;
	private String state;
	private int pincode;
	@Column(name="phone_number")
	private String phoneNumber;
	@Column(name="user_id")
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
	public static AddressDTO valueOf(AddressEntity adressEntity) {
		// TODO Auto-generated method stub
		
		AddressDTO address=new AddressDTO();
		address.setAddressId(adressEntity.getAddressId());
		address.setAddress(adressEntity.getAddress());
		address.setCity(adressEntity.getCity());
		address.setState(adressEntity.getState());
		address.setPincode(adressEntity.getPincode());
		address.setPhoneNumber(adressEntity.getPhoneNumber());
		
		return address;
	}
	
	
	
	
}
