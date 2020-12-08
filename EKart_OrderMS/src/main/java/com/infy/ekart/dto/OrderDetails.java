package com.infy.ekart.dto;

import java.time.LocalDate;



public class OrderDetails {

	private int orderId;
	private String displayName;
	private String category;
	private String sellerName;
	private double price;
	private int quantity;
	private double totalPrice;
	private LocalDate orderedDate;
	private String orderStatus;
	private boolean btnReviewProduct;
	private boolean btnReviewSeller;
	private boolean btnCancel;
	private boolean btnReturn;
	
	public boolean isBtnReviewProduct() {
		return btnReviewProduct;
	}
	public void setBtnReviewProduct(boolean btnReviewProduct) {
		this.btnReviewProduct = btnReviewProduct;
	}
	public boolean isBtnReviewSeller() {
		return btnReviewSeller;
	}
	public void setBtnReviewSeller(boolean btnReviewSeller) {
		this.btnReviewSeller = btnReviewSeller;
	}
	public boolean isBtnCancel() {
		return btnCancel;
	}
	public void setBtnCancel(boolean btnCancel) {
		this.btnCancel = btnCancel;
	}
	public boolean isBtnReturn() {
		return btnReturn;
	}
	public void setBtnReturn(boolean btnReturn) {
		this.btnReturn = btnReturn;
	}
	public OrderDetails() {
		super();
	}

	public OrderDetails(int orderId, String displayName, String category, String sellerName, double price, int quantity,
			double totalPrice, LocalDate orderedDate, String orderStatus, boolean btnReviewProduct,
			boolean btnReviewSeller, boolean btnCancel, boolean btnReturn) {
		super();
		this.orderId = orderId;
		this.displayName = displayName;
		this.category = category;
		this.sellerName = sellerName;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderedDate = orderedDate;
		this.orderStatus = orderStatus;
		this.btnReviewProduct = btnReviewProduct;
		this.btnReviewSeller = btnReviewSeller;
		this.btnCancel = btnCancel;
		this.btnReturn = btnReturn;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public LocalDate getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(LocalDate localDate) {
		this.orderedDate = localDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}
