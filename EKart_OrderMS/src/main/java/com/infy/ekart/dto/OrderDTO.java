package com.infy.ekart.dto;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infy.ekart.entity.OrderEntity;

public class OrderDTO {
	private int orderId;
	private String status;
	private int productId;
	private String sellerId;
	private int quantity;
	private LocalDate orderDate;
	private int addressId;
	private String paymentType;
	private int cardId;
	private String userId;
	private float price;
	

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public static OrderDTO valueOf(OrderEntity orderEntity) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderId(orderEntity.getOrderId());
		orderDTO.setStatus(orderEntity.getStatus());
		orderDTO.setProductId(orderEntity.getProductId());
		orderDTO.setSellerId(orderEntity.getSellerId());
		orderDTO.setQuantity(orderEntity.getQuantity());
		orderDTO.setOrderDate(orderEntity.getOrderDate());
		orderDTO.setAddressId(orderEntity.getAddressId());
		orderDTO.setPaymentType(orderEntity.getPaymentType());
		orderDTO.setCardId(orderEntity.getCardId());
		orderDTO.setUserId(orderEntity.getUserId());
		return orderDTO;
	}

	public OrderEntity createOrderEntity() {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setStatus(this.status);
		orderEntity.setProductId(this.productId);
		orderEntity.setSellerId(this.sellerId);
		orderEntity.setQuantity(this.quantity);
		orderEntity.setOrderDate(this.orderDate);
		orderEntity.setAddressId(this.addressId);
		orderEntity.setPaymentType(this.paymentType);
		orderEntity.setCardId(this.cardId);
		orderEntity.setUserId(this.userId);
		return orderEntity;
	}

}
