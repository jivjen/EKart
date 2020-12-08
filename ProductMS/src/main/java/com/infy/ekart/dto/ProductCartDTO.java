package com.infy.ekart.dto;

public class ProductCartDTO {
	private String sellerId;
	private int cartId;
	private int productId;
	private int productCartId;
	private float cartOfferPrice;
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
