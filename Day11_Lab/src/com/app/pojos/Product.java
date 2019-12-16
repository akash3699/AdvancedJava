package com.app.pojos;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "products")
public class Product {
	private Integer id;
	private String name;
	private double price;
	private Date expDate;
	public Product() {
		System.out.println("int ctor Product pojo");
	}
	/**
	 * @param name
	 * @param price
	 * @param expDate
	 */
	public Product(String name, double price, Date expDate) {
		super();
		this.name = name;
		this.price = price;
		this.expDate = expDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Column(name = "Exp_date")
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", expDate=" + expDate + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
