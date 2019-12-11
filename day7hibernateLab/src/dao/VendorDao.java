package dao;

import static utils.HibernateUtils.getSf;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import pojos.Vendors;

public class VendorDao implements IVendorDao
{

	@Override
	public String registerVendor(Vendors v) {
		Session hs = getSf().openSession();
		// begin tx
		Transaction tx = hs.beginTransaction();
		try {
			hs.save(v);// v---persistent
			tx.commit();// hib performs auto dirty checking upon commit --insert query
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();
		}
		return "User registered with ID =" + v.getId();
	}

	@Override
	public Vendors getDetails(int id) {
		Vendors v=null;
		Session hs = getSf().openSession();
		// begin tx
		Transaction tx = hs.beginTransaction();
		try {
			v = hs.get(Vendors.class, id);
			tx.commit();// hib performs auto dirty checking upon commit --insert query
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();
		}
		return v;
	}

	@Override
	public List<Vendors> getAllVendors() {
		List<Vendors> l1 = null;
		String jpql = "select v from Vendors v";
		// get session from SF
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, Vendors.class).getResultList();// list of persistent POJOs
			tx.commit();// L1 cache destroyed,cn rets to the pool,session is closed
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}finally {
			if (hs != null)
				hs.close();
		}
		return l1;// l1 -- list of detached entities.
	}

	@Override
	public List<Vendors> getSelectedVendors(Date dt, double amount) {
		List<Vendors> users = null;
		String jpql = "select v from Vendors v where v.reg_date between :strt and DATE() and v.reg_amount < :am ";
		// session
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			users = hs.createQuery(jpql, Vendors.class).setParameter("strt", dt)
					.setParameter("am", amount).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;
	}
	

}
