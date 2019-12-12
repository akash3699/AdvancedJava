package dao;

import static utils.HibernateUtils.getSf;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.BankAccount;
import pojos.Vendor;

public class BankAccountDaoImpl implements IBankAccountDao{

	@Override
	public String createAccount(int vendorId, BankAccount a) {
		Vendor v=null;
		String message=""; 
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try
		{
		
			v = hs.get(Vendor.class, vendorId);
			if(v==null)
			{
				message = "Vendor not found";
			}
			else
			{
				
				v.addAcoount(a);
				message = "Account Added Successfully";
			}
			tx.commit();// hib performs auto dirty checking upon commit --insert query
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return message;
	}

	@Override
	public String withdraw(int acctId, double amount) {
		BankAccount ba=null;
		String message=""; 
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try
		{
		
			ba = hs.get(BankAccount.class, acctId);
			if(ba==null)
			{
				message = "Account not found";
			}
			else
			{
				
				ba.setBalance(ba.getBalance()-amount);
				message = "Account Withdraw Successfully";
			}
			tx.commit();// hib performs auto dirty checking upon commit --insert query
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return message;
	}

	@Override
	public String closeAccount(int vendorId, int acctId) {
		Vendor v=null;
		BankAccount b =null;
		String message=""; 
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try
		{
		
			v = hs.get(Vendor.class, vendorId);
			if(v==null)
			{
				message = "Vendor not found";
			}
			else
			{
				b = hs.get(BankAccount.class, acctId);
				if(b!=null)
				{
					v.removeAcoount(b);
					v.getBankAccounts().forEach(System.out::println);
					message = "Account Removed Successfully";
				}
				else
				message = "Account Not Found";
			}
			tx.commit();// hib performs auto dirty checking upon commit --insert query
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return message;
	}

}
