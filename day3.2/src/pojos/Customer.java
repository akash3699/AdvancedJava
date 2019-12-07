package pojos;

import java.sql.Date;

public class Customer {
	private int custId;
	private String email, password;
	private double regAmount;
	private Date regDate;
	private String name;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int custId, String email, String password, double regAmount, Date regDate, String name) {
		super();
		this.custId = custId;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.name = name;
	}

	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
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
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", email=" + email + ", regAmount=" + regAmount + ", regDate=" + regDate
				+ ", name=" + name + "]";
	}
	
	
}
