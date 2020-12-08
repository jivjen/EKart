package com.infy.ekart.dto;

import javax.validation.constraints.Max;

public class ProductCartDTO {
	private String sellerId;
	private int cartId;
	private int productId;
	private int productCartId;
	private float cartOfferPrice;
	@Max(value = 4)
	private int quantity;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductCartId() {
		return productCartId;
	}
	public void setProductCartId(int productCartId) {
		this.productCartId = productCartId;
	}
	public float getCartOfferPrice() {
		return cartOfferPrice;
	}
	public void setCartOfferPrice(float cartOfferPrice) {
		this.cartOfferPrice = cartOfferPrice;
	}
	
}
