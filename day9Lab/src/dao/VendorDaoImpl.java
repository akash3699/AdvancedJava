package dao;

import static utils.HibernateUtils.getSf;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Vendor;


public class VendorDaoImpl implements IVendorDao {

	@Override
	public Vendor getVendorDetails(String email) {
		String jpql = "select v from Vendor v where v.email = :em";
		
		Vendor v=null;
		Session hs = getSf().getCurrentSession();
		// begin tx
		Transaction tx = hs.beginTransaction();
		try {
			v = hs.createQuery(jpql, Vendor.class).setParameter("em", email).getSingleResult();
				
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
	

}
