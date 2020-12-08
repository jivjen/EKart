package com.infy.ekart.dto;


public class SellerDTO {
	private String sellerProductsId;
	private String sellerId;
	private String productId;
	private double deliveryCharge;
	private double price;
	private double discount;
	
	@Override
	public String toString() {
		return "SellerProduct [sellerProductsId=" + sellerProductsId + ", sellerId=" + sellerId + ", productId="
				+ productId + ", deliveryCharge=" + deliveryCharge + ", price=" + price + ", discount=" + discount
				+ "]";
	}

	public String getSellerProductsId() {
		return sellerProductsId;
	}

	public void setSellerProductsId(String sellerProductsId) {
		this.sellerProductsId = sellerProductsId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
}
