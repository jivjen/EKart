package com.infy.ekart.dto;


public class CartDetailsDTO {

	private String displayName;
	private String category;
	private String sellerName;
	private double price;
	private double deliveryCharge;
	private Integer quantity;
	private double total;
	private double cartOfferPrice;
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getCartOfferPrice() {
		return cartOfferPrice;
	}
	public void setCartOfferPrice(double cartOfferPrice) {
		this.cartOfferPrice = cartOfferPrice;
	}
	public CartDetailsDTO(String displayName, String category, String sellerName, double price, double deliveryCharge,
			Integer quantity, double total, double cartOfferPrice) {
		super();
		this.displayName = displayName;
		this.category = category;
		this.sellerName = sellerName;
		this.price = price;
		this.deliveryCharge = deliveryCharge;
		this.quantity = quantity;
		this.total = total;
		this.cartOfferPrice = cartOfferPrice;
	}
	public CartDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
