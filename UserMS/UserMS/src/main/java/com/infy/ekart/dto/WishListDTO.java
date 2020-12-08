package com.infy.ekart.dto;

public class WishListDTO {

	private Integer wishlistId;
	private String userId;
	private Integer productId;
	
	public WishListDTO() {
		super();
	}

	public Integer getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(Integer wishlistId) {
		this.wishlistId = wishlistId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "WishListEntity [wishlistId=" + wishlistId + ", userId=" + userId + ", productId=" + productId + "]";
	}

}
