package com.infy.ekart.dto;

public class ProductReviewDTO {
	private int productReviewIid;
	private int productId;
	private String userId;
	private String reviewComments;
	private int rating;
	
	@Override
	public String toString() {
		return "ProductReview [productReviewIid=" + productReviewIid + ", productId=" + productId + ", userId=" + userId
				+ ", reviewComments=" + reviewComments + ", rating=" + rating + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public int getProductReviewIid() {
		return productReviewIid;
	}

	public void setProductReviewIid(int productReviewIid) {
		this.productReviewIid = productReviewIid;
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

	public String getReviewComments() {
		return reviewComments;
	}

	public void setReviewComments(String reviewComments) {
		this.reviewComments = reviewComments;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
