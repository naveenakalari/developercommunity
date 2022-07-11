package com.dcp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Entity
@Table(name="users")
public class User{
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private int userId;
	 @Column(name="userpassword")
	 private String password;
	 @Column(name="userrole")
	 private String role;
	 
	 public User() {}


	public User(String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}

	
}
