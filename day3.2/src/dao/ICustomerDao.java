package dao;

import pojos.Customer;

public interface ICustomerDao {
	Customer validateUser(String email, String pwd) throws Exception;
}
