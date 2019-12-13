package dao;

import pojos.BankAccount;

public interface IBankAccountDao {

	String createAccount(int vendorId,BankAccount a);
	String withdraw(int acctId,double amount);
	String closeAccount(int vendorId,int acctId);
}
