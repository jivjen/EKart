package com.infy.ekart.dto;


import java.util.*;
public class CartDTO {

	//private List<CartDetailsDTO> checkoutItems;
	private List<CartDetailsDTO> cartItems;
	private double totalPrice;
	private double totalDeliveryCharge;
	private double grandTotal;
	
	
	
//	public List<CartDetailsDTO> getListOfCartDTO(){
//		return checkoutItems;
//	}
//	
//	public void setListOfCartDTO(List<CartDetailsDTO> checkoutItems) {
//		this.checkoutItems=checkoutItems;
//	}
	
//	public List<CartDetailsDTO> getCheckoutItems() {
//		return checkoutItems;
//	}
//	public void setCheckoutItems(List<CartDetailsDTO> checkoutItems) {
//		this.checkoutItems = checkoutItems;
//	}
	public List<CartDetailsDTO> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartDetailsDTO> cartItems) {
		this.cartItems = cartItems;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getTotalDeliveryCharge() {
		return totalDeliveryCharge;
	}
	public void setTotalDeliveryCharge(double totalDeliveryCharge) {
		this.totalDeliveryCharge = totalDeliveryCharge;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	
	
	
	
}
