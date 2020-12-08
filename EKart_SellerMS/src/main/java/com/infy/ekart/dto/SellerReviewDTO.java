package com.infy.ekart.dto;

import java.time.LocalDate;

import com.infy.ekart.entity.SellerReviewsEntity;


public class SellerReviewDTO {

	private Integer userSellerId;
	private String sellerId;
	private Integer rating;
	private String userId;
	private LocalDate dateOfReview;
	private String reviewComments;
	public Integer getUserSellerId() {
		return userSellerId;
	}
	public void setUserSellerId(Integer userSellerId) {
		this.userSellerId = userSellerId;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public LocalDate getDateOfReview() {
		return dateOfReview;
	}
	public void setDateOfReview(LocalDate dateOfReview) {
		this.dateOfReview = dateOfReview;
	}
	public String getReviewComments() {
		return reviewComments;
	}
	public void setReviewComments(String reviewComments) {
		this.reviewComments = reviewComments;
	}
	@Override
	public String toString() {
		return "SellerReview [userSellerId=" + userSellerId + ", sellerId=" + sellerId + ", rating=" + rating
				+ ", userId=" + userId + ", dateOfReview=" + dateOfReview + ", reviewComments=" + reviewComments + "]";
	}
	
	public static SellerReviewsEntity changeToEntity(SellerReviewDTO dto)
	{
		SellerReviewsEntity s=new SellerReviewsEntity();
		s.setDateOfReview(dto.getDateOfReview());
		s.setRating(dto.getRating());
		s.setReviewComments(dto.getReviewComments());
		s.setSellerId(dto.getSellerId());
		s.setUserId(dto.getUserId());
		return s;
	}
	
}
