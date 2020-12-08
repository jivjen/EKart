package com.infy.ekart.entity;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infy.ekart.dto.OrderDTO;

@Entity
@Table(name = "order")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "order_id")
	private int orderId;
	private String status;
	public OrderEntity(String status, int productId, String sellerId, int quantity, LocalDate orderDate,
			int addressId, String paymentType, int cardId, String userId, float price) {
		super();
		this.status = status;
		this.productId = productId;
		this.sellerId = sellerId;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.addressId = addressId;
		this.paymentType = paymentType;
		this.cardId = cardId;
		this.userId = userId;
		this.price = price;
	}

	public OrderEntity(int orderId, String status, int productId, String sellerId, int quantity,
			LocalDate orderDate, int addressId, String paymentType, int cardId, String userId, float price) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.productId = productId;
		this.sellerId = sellerId;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.addressId = addressId;
		this.paymentType = paymentType;
		this.cardId = cardId;
		this.userId = userId;
		this.price = price;
	}

	public OrderEntity() {
		super();
	}

	@Column(name = "product_id")
	private int productId;
	@Column(name = "seller_id")
	private String sellerId;
	
	private int quantity;
	@Column(name = "order_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate orderDate;
	@Column(name = "address_id")
	private int addressId;
	@Column(name = "payment_type")
	private String paymentType;
	@Column(name = "card_id")
	private int cardId;
	@Column(name = "user_id")
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
	
	public static OrderDTO prepareDTO(OrderEntity orderEntity) {
		OrderDTO orderDto = new OrderDTO();
		orderDto.setOrderId(orderEntity.getOrderId());
		orderDto.setAddressId(orderEntity.getAddressId());
		orderDto.setCardId(orderEntity.getCardId());
		orderDto.setOrderDate(orderEntity.getOrderDate());
		orderDto.setPaymentType(orderEntity.getPaymentType());
		orderDto.setPrice(orderEntity.getPrice());
		orderDto.setProductId(orderEntity.getProductId());
		orderDto.setQuantity(orderEntity.getQuantity());
		orderDto.setSellerId(orderEntity.getSellerId());
		orderDto.setStatus(orderEntity.getStatus());
		orderDto.setUserId(orderEntity.getUserId());
		return orderDto;
	}

}
