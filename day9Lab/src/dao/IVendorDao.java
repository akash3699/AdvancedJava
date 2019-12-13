package dao;

import pojos.Vendor;

public interface IVendorDao {
	Vendor getVendorDetails(String email);
}
