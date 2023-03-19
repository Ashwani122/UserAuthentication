package com.ekart.Dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("uId")
	private Integer userId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("email")
	@Email
	private String email;
	
	@JsonProperty("userName")
	private String userName;
	
	@JsonProperty("pwd")
	@NotNull
	private String password;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
