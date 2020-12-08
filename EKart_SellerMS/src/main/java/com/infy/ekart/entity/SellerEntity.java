package com.infy.ekart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="seller")
public class SellerEntity {
	
	@Id
	@Column(name="seller_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@GenericGenerator(name = "id_generator", strategy = "com.infy.ekart.generator.SellerIdGenerator")
	private String sellerId;
	
	private String name;
	
	private String password;
	
	private String email;
	
	
	
	public SellerEntity(String name, String password, String email) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public SellerEntity(String sellerId, String name, String password, String email) {
		super();
		this.sellerId = sellerId;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public String getSellerId() {
		return sellerId;
	}

	public SellerEntity() {
		super();
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
