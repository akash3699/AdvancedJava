package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.UserRole;
import com.app.pojos.Vendor;


@Repository
@Transactional
public class VendorDaoImpl implements IVendorDao {
	// dependency
	@Autowired
	private SessionFactory sf;

	@Override
	public List<Vendor> listVendors() {
		String jpql = "select u from Vendor u where u.role=:rl";
		return sf.getCurrentSession().createQuery(jpql, Vendor.class).setParameter("rl", UserRole.VENDOR).getResultList();
	}

	@Override
	public String deleteVendorDetails(int vendorId) {
		String mesg="Vendor deletion failed....";
		Session hs=sf.getCurrentSession();
		//get vendor detail from id
		Vendor u=hs.get(Vendor.class, vendorId);
		if(u != null)
		{
			hs.delete(u);
			mesg="Vendor with ID : "+vendorId+" deletion succeeded";
		}
		return mesg;
	}

	@Override
	public String addVendorPojo(Vendor u) {
		sf.getCurrentSession().save(u);
		return "Vendor added Successfully";
	}
	
	@Override
	public Vendor getVendorPojo(int vid) {
		
		return sf.getCurrentSession().get(Vendor.class, vid);
	}
	
	@Override
	public String updateVendorPojo(Vendor u, int vid) {
		
		Vendor u1 = sf.getCurrentSession().get(Vendor.class, vid);
		u1.setName(u.getName());
		u1.setEmail(u.getEmail());
		u1.setPassword(u.getPassword());
		u1.setReg_amount(u.getReg_amount());
		u1.setReg_date(u.getReg_date());
		return "Updated successfully";
	}
	
	@Override
	public Vendor authenticateUser(String email, String pwd) {
		String jpql = "select u from Vendor u where u.email = :em and u.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, Vendor.class).setParameter("em", email).setParameter("pass", pwd)
				.getSingleResult();
	}

}
