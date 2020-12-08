package com.infy.ekart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity {
	@Id
	@Column(name = "product_id")
	private int productId;
	@Column(name = "display_name")
	private String displayName;
	@Column(name = "short_desc")
	private String shortDesc;
	private String description;
	private String category;
	private float price;
	@Column(name="image_url")
	private String imageUrl;
	
	
	
	public ProductEntity() {
		super();
	}
	public ProductEntity(int productId, String displayName, String shortDesc, String description, String category,
			float price, String imageUrl) {
		super();
		this.productId = productId;
		this.displayName = displayName;
		this.shortDesc = shortDesc;
		this.description = description;
		this.category = category;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	public int getProductId() {
		return productId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
