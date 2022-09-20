package com.restexample.restdemo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
	 @Id
	 private int userName;
	 private String password;
	 public Login() {}
	 public int getUserName() {
		return userName;
	}
	public void setUserName(int userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
