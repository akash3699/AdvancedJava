package com.app.sunbeam;

import java.time.LocalDate;

public class Tutorial {
	
	private String author;
	private LocalDate createdOn;
	private String details;
	public Tutorial() {
		// TODO Auto-generated constructor stub
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LocalDate getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "Tutorial [author=" + author + ", createdOn=" + createdOn + ", details=" + details + "]";
	}
	public Tutorial(String author, LocalDate createdOn, String details) {
		super();
		this.author = author;
		this.createdOn = createdOn;
		this.details = details;
	}
	

}
