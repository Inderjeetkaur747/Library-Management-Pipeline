package com.training.advancejava.librarymanagement.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class User {
	@NotBlank(message = "User Id can not be empty !!")
	@Size(min = 5, max = 50, message = "User Id must be between 5-50 characters")
	@Id
	private String userId;
	
	@NotBlank(message = "Password can not be empty !!")
	@Size(min = 5, max = 50, message = "Password must be between 5-50 characters")
	private String userPassword;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPassword=" + userPassword + "]";
	}

	public User(
			@NotBlank(message = "User Id can not be empty !!") @Size(min = 5, max = 50, message = "User Id must be between 5-50 characters") String userId,
			@NotBlank(message = "Password can not be empty !!") @Size(min = 5, max = 50, message = "Password must be between 5-50 characters") String userPassword) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
