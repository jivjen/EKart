package com.infy.ekart.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seller_reviews")
public class SellerReviewsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="review_id")
	private int reviewId;
	
	@Column(name="seller_id")
	private String sellerId;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="review_comments")
	private String reviewComments;
	
	public SellerReviewsEntity(String sellerId, String userId, String reviewComments, int rating,
			LocalDate dateOfReview) {
		super();
		this.sellerId = sellerId;
		this.userId = userId;
		this.reviewComments = reviewComments;
		this.rating = rating;
		this.dateOfReview = dateOfReview;
	}

	public SellerReviewsEntity() {
		super();
	}

	private int rating;
	
	private LocalDate dateOfReview;
	public SellerReviewsEntity(int reviewId, String sellerId, String userId, String reviewComments, int rating,
			LocalDate dateOfReview) {
		super();
		this.reviewId = reviewId;
		this.sellerId = sellerId;
		this.userId = userId;
		this.reviewComments = reviewComments;
		this.rating = rating;
		this.dateOfReview = dateOfReview;
	}

	public LocalDate getDateOfReview() {
		return dateOfReview;
	}

	public void setDateOfReview(LocalDate dateOfReview) {
		this.dateOfReview = dateOfReview;
	}

	public SellerReviewsEntity(String sellerId, String userId, String reviewComments, int rating) {
		super();
		this.sellerId = sellerId;
		this.userId = userId;
		this.reviewComments = reviewComments;
		this.rating = rating;
	}

	public SellerReviewsEntity(int reviewId, String sellerId, String userId, String reviewComments, int rating) {
		super();
		this.reviewId = reviewId;
		this.sellerId = sellerId;
		this.userId = userId;
		this.reviewComments = reviewComments;
		this.rating = rating;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
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
