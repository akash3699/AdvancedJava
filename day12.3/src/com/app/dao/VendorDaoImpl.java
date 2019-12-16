package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User;
import com.app.pojos.UserRole;

@Repository
@Transactional
public class VendorDaoImpl implements IVendorDao {
	// dependency
	@Autowired
	private SessionFactory sf;
	@Autowired
	private IVendorDao dao;

	@Override
	public List<User> listVendors() {
		String jpql = "select u from User u left outer join fetch u.bankAccounts where u.role=:rl";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("rl", UserRole.VENDOR).getResultList();
	}

	@Override
	public String deleteVendorDetails(int vendorId) {
		String mesg="Vendor deletion failed....";
		Session hs=sf.getCurrentSession();
		//get vendor detail from id
		User u=hs.get(User.class, vendorId);
		if(u != null)
		{
			hs.delete(u);
			mesg="Vendor with ID : "+vendorId+" deletion succeeded";
		}
		return mesg;
	}
	
	@Override
	public String addVendorPojo(User u) {
		sf.getCurrentSession().save(u);
		return "Vendor added Successfully";
	}
	
	@Override
	public User getVendorPojo(int vid) {
		
		return sf.getCurrentSession().get(User.class, vid);
	}
	
	@Override
	public String updateVendorPojo(User u, int vid) {
		
		User u1 = sf.getCurrentSession().get(User.class, vid);
		u1.setName(u.getName());
		u1.setEmail(u.getEmail());
		u1.setPassword(u.getPassword());
		u1.setRegAmount(u.getRegAmount());
		u1.setRegDate(u.getRegDate());
		return "Updated successfully";
	}
	
	@Override
	public User authenticateUser(String email, String pwd) {
		String jpql = "select u from Vendor u left outer join fetch u.bankAccounts where u.email = :em and u.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", pwd)
				.getSingleResult();
	}

}
