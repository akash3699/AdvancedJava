package com.app.dao;

import java.util.List;

import com.app.pojos.User;

public interface IVendorDao {
	List<User> listVendors();
	String deleteVendorDetails(int vendorId);
	User getVendorPojo(int vid);
	String updateVendorPojo(User u, int vid);
	User authenticateUser(String email, String pwd);
	String addVendorPojo(User u);
}
