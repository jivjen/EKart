package com.infy.ekart.dto;

import java.util.List;

public class CartDetails {

	private List<ProductDTO> products;
	
	private List<SellerDTO> sellers;

	public CartDetails() {
		super();
	}

	public CartDetails(List<ProductDTO> products, List<SellerDTO> sellers) {
		super();
		this.products = products;
		this.sellers = sellers;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	public List<SellerDTO> getSellers() {
		return sellers;
	}

	public void setSellers(List<SellerDTO> sellers) {
		this.sellers = sellers;
	}
	
}
