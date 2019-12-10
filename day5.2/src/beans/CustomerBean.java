package beans;

import dao.CustomerDaoImpl;
import pojos.Customer;

public class CustomerBean {
	//D.M ---properties of Java bean
	private String email,password;
	private CustomerDaoImpl dao;
	private Customer details;//validated cust dtls
	//login status mesg
	private String message;
	//def constr
	public CustomerBean() throws Exception{
		System.out.println("cust bean constr");
		//create dao inst
		dao=new CustomerDaoImpl();
	}
	//setters n getters
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
	public CustomerDaoImpl getDao() {
		return dao;
	}
	public void setDao(CustomerDaoImpl dao) {
		this.dao = dao;
	}
	public Customer getDetails() {
		return details;
	}
	public void setDetails(Customer details) {
		this.details = details;
	}
	
	public String getMessage() {
		return message;
	}
	//B.L method for customer auth.
	public String authenticateCustomer() throws Exception{
		System.out.println("in B.L auth "+email+" "+password);
		details=dao.validateUser(email, password);
		if(details != null) {
			message="Login Successful";
			return "category";
		}
		message="Invalid Login ,Pls Retry";
		return "login";//returning dyn nav outcome to JSP
	}
	

}
