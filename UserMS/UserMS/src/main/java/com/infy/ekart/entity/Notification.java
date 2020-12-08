package com.infy.ekart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="notification_id")
	private int notificationId;
	
	@Column(name="message_type")
	private String messageType;
	
	private String message;
	
	@Column(name="user_id")
	private String userId;
	

	public Notification(String messageType, String message, String userId) {
		super();
		this.messageType = messageType;
		this.message = message;
		this.userId = userId;
	}

	public Notification(int notificationId, String messageType, String message, String userId) {
		super();
		this.notificationId = notificationId;
		this.messageType = messageType;
		this.message = message;
		this.userId = userId;
	}

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
