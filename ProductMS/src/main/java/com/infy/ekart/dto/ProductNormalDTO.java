package com.infy.ekart.dto;

import com.infy.ekart.entity.ProductEntity;

public class ProductNormalDTO {
	private int productId;
	private String displayName;
	private String shortDesc;
	private String description;
	private String category;
	private float price;
	private String imageUrl;
	
	
	
	public ProductNormalDTO() {
		super();
	}
	public ProductNormalDTO(int productId, String displayName, String shortDesc, String description, String category,
			float price,  float discount) {
		super();
		this.productId = productId;
		this.displayName = displayName;
		this.shortDesc = shortDesc;
		this.description = description;
		this.category = category;
		this.price = price;
		this.discount = discount;
	}
	
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	private float discount;
	public int getProductId() {
		return productId;
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
	public static ProductDTO valueOf(ProductEntity productEntity) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(productEntity.getProductId());
		productDTO.setDisplayName(productEntity.getDisplayName());
		productDTO.setShortDesc(productEntity.getShortDesc());
		productDTO.setDescription(productEntity.getDescription());
		productDTO.setCategory(productEntity.getCategory());
		productDTO.setPrice(productEntity.getPrice());	
		return productDTO;
	}

	public ProductEntity createProductEntity() {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setDisplayName(this.displayName);
		productEntity.setShortDesc(this.shortDesc);
		productEntity.setDescription(this.description);
		productEntity.setCategory(this.category);
		productEntity.setPrice(this.price);
		return productEntity;
	}
}