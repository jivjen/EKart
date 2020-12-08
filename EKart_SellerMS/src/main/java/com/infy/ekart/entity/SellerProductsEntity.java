package com.infy.ekart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seller_products")
public class SellerProductsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="seller_products_id")
	private int sellerProductsId;
	
	@Column(name="seller_id")
	private String sellerId;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="delivery_charge")
	private double deliveryCharge;
	
	public SellerProductsEntity() {
		super();
	}

	public SellerProductsEntity(String sellerId, int productId, double deliveryCharge) {
		super();
		this.sellerId = sellerId;
		this.productId = productId;
		this.deliveryCharge = deliveryCharge;
	}

	public SellerProductsEntity(int sellerProductsId, String sellerId, int productId, double deliveryCharge) {
		super();
		this.sellerProductsId = sellerProductsId;
		this.sellerId = sellerId;
		this.productId = productId;
		this.deliveryCharge = deliveryCharge;
	}

	public int getSellerProductsId() {
		return sellerProductsId;
	}

	public void setSellerProductsId(int sellerProductsId) {
		this.sellerProductsId = sellerProductsId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	
	
	
}
