package com.infy.ekart.dto;

import com.infy.ekart.entity.SellerProductsEntity;

public class SellerProductDTO {
	private int sellerProductsId;
	private String sellerId;
	private int productId;
	private double deliveryCharge;

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

	public static SellerProductDTO valueOf(SellerProductsEntity sellerProductEntity) {
		SellerProductDTO sellerProductsDTO = new SellerProductDTO();
		sellerProductsDTO.setSellerProductsId(sellerProductEntity.getSellerProductsId());
		sellerProductsDTO.setSellerId(sellerProductEntity.getSellerId());
		sellerProductsDTO.setProductId(sellerProductEntity.getProductId());
		sellerProductsDTO.setDeliveryCharge(sellerProductEntity.getDeliveryCharge());
		return sellerProductsDTO;
	}

	public SellerProductsEntity createSellerProductEntity() {
		SellerProductsEntity sellerProductEntity = new SellerProductsEntity();
		sellerProductEntity.setSellerId(this.sellerId);
		sellerProductEntity.setProductId(this.productId);
		sellerProductEntity.setDeliveryCharge(this.deliveryCharge);
		return sellerProductEntity;
	}

}
