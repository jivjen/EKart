package com.infy.ekart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_cart")
public class ProductCartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="product_cart_id")
	private int productCartId;

	@Column(name="product_id")
	private int productId;

	@Column(name="seller_id")
	private String sellerId;

	private int quantity;

	@Column(name="cart_id")
	private int cartId;

	@Column(name="cart_offer_price")
	private double cartOfferPrice;


	
	public ProductCartEntity(int productId, String sellerId, int quantity, int cartId, double cartOfferPrice) {
		super();
		this.productId = productId;
		this.sellerId = sellerId;
		this.quantity = quantity;
		this.cartId = cartId;
		this.cartOfferPrice = cartOfferPrice;
	}

	public ProductCartEntity(int productCartId, int productId, String sellerId, int quantity, int cartId,
			double cartOfferPrice) {
		super();
		this.productCartId = productCartId;
		this.productId = productId;
		this.sellerId = sellerId;
		this.quantity = quantity;
		this.cartId = cartId;
		this.cartOfferPrice = cartOfferPrice;
	}

	public ProductCartEntity() {
		super();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductCartId() {
		return productCartId;
	}

	public void setProductCartId(int productCartId) {
		this.productCartId = productCartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	public double getCartOfferPrice() {
		return cartOfferPrice;
	}

	public void setCartOfferPrice(double cartOfferPrice) {
		this.cartOfferPrice = cartOfferPrice;
	}

}
