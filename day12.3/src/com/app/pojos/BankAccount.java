package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "Accounts")
public class BankAccount {
	private Integer accountNo;
	private AcType type;
	private double balance;
	private User owner;
	
	
	public BankAccount() {
	}

	public BankAccount( AcType type, double balance) {
		super();
		
		this.type = type;
		this.balance = balance;
	}
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_no")
	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	@Enumerated(EnumType.STRING) // enum constant name will be added in DB
	@Column(length = 20)
	public AcType getType() {
		return type;
	}

	public void setType(AcType type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	@ManyToOne
	@JoinColumn(name = "Vendor_id")
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", type=" + type + ", balance=" + balance + ", owner=" + owner
				+ "]";
	}


	
}
