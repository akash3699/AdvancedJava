package com.app.dao;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorDao {
	List<Vendor> listVendors();
	String deleteVendorDetails(int vendorId);
	String addVendorPojo(Vendor u);
	Vendor getVendorPojo(int vid);
	String updateVendorPojo(Vendor u,int vid);
	Vendor authenticateUser(String email,String pwd);
}
