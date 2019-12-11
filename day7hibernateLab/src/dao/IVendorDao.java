package dao;

import java.util.Date;
import java.util.List;

import pojos.Vendors;

public interface IVendorDao {

	String registerVendor(Vendors v);
	Vendors getDetails(int id);
	List<Vendors> getAllVendors();
	List<Vendors> getSelectedVendors(Date dt,double amount);
	List<Object[]> getUsersByRole();
	List<Vendors> getSelectedUsersDetails(Date d1);
	
}
