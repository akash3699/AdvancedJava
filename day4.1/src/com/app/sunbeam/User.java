package com.app.sunbeam;

import java.time.LocalDate;

public class User {
	private String email, name, password;
	private LocalDate dob;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String email, String name, String password, LocalDate dob) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", dob=" + dob + "]";
	}
	

}