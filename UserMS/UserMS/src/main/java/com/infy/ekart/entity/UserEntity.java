package com.infy.ekart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
public class UserEntity {
	
	public UserEntity() {
		super();
	}

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@GenericGenerator(name = "id_generator", strategy = "com.infy.ekart.generator.UserIdGenerator")
	private String userId;
	
	private String name;
	
	private String email;
	
	private String password;
	
	

	public UserEntity(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UserEntity(String userId, String name, String email, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
