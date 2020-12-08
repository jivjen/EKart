package com.infy.ekart.dto;
public class AddCartDTO {
	private int productId;
	private String sellerName;
	private int quantity;
	private String category;
	public int getProductName() {
		return productId;
	}
	public void setProductName(int productId) {
		this.productId = productId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}
