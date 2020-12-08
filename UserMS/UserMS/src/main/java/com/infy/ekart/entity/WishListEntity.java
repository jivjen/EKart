package com.infy.ekart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wishlist")
public class WishListEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="wishlist_id")
	private int wishlistId;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="user_id")
	private String userId;
	
	public WishListEntity() {
		
	}

	public WishListEntity(int productId, String userId) {
		super();
		this.productId = productId;
		this.userId = userId;
	}

	public WishListEntity(int wishlistId, int productId, String userId) {
		super();
		this.wishlistId = wishlistId;
		this.productId = productId;
		this.userId = userId;
	}

	public int getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
