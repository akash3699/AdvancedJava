package dao;

import org.hibernate.*;
import static utils.HibernateUtils.*;

import java.util.Date;
import java.util.List;

import pojos.User;
import pojos.UserRole;

public class UserDaoImpl implements IUserDao {

	@Override
	public String registerUser(User u) {
		// u --- transient
		// get session from SF
		Session hs = getSf().openSession();
		// begin tx
		Transaction tx = hs.beginTransaction();
		try {
			Integer id = (Integer) hs.save(u);// u---persistent
			tx.commit();// hib performs auto dirty checking upon commit --insert query
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();
		}
		return "User registered with ID =" + u.getId();// u --- DETACHED
	}

	@Override
	public User getDetails(int id) {
		User u = null;// u --- Doesn't exist
		// get sesison from SF
		Session hs = getSf().openSession();
		// begin tx
		Transaction tx = hs.beginTransaction();
		try {
			u = hs.get(User.class, id); // if id exists --- u -- PERSISTENT
			u = hs.get(User.class, id);
			u = hs.get(User.class, id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();// L1 cache is destroyed,cn rets to the pool , session is closed
		}

		return u; // u -- DETACHED
	}

	@Override
	public List<User> getAllUsers() {
		List<User> l1 = null;
		String jpql = "select u from User u";
		// get session from SF
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, User.class).getResultList();// list of persistent POJOs
			tx.commit();// L1 cache destroyed,cn rets to the pool,session is closed
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;// l1 -- list of detached entities.
	}

	@Override
	public List<User> getSelectedUsers(Date d1, Date d2, UserRole role1) {
		List<User> users = null;
		String jpql = "select u from User u where u.regDate between :strt and :end and u.role=:rl ";
		// session
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			users = hs.createQuery(jpql, User.class).setParameter("strt", d1).setParameter("end", d2)
					.setParameter("rl", role1).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;
	}

	@Override
	public List<String> getSelectedUserNames(Date d1, Date d2, UserRole role1) {
		List<String> names = null;
		String jpql = "select u.name from User u where u.regDate between :strt and :end and u.role=:rl ";

		// get session from SF
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			names = hs.createQuery(jpql, String.class).setParameter("strt", d1).setParameter("end", d2)
					.setParameter("rl", role1).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return names;
	}

	@Override
	public List<Object[]> getSelectedUserNamesNAmount(Date d1, Date d2, UserRole role1) {
		List<Object[]> data = null;
		String jpql = "select u.name,u.regAmount from User u where u.regDate between :strt and :end and u.role=:rl ";

		// get session from SF
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			data = hs.createQuery(jpql, Object[].class).setParameter("strt", d1).setParameter("end", d2)
					.setParameter("rl", role1).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return data;

	}

	@Override
	public List<User> getSelectedUsersDetails(Date d1, Date d2, UserRole role1) {
		List<User> users = null;
		String jpql = "select new pojos.User(u.name,u.regAmount,u.regDate)  from User u where u.regDate between :strt and :end and u.role=:rl ";
		//get session from SF
				Session hs=getSf().getCurrentSession();
				//tx
				Transaction tx=hs.beginTransaction();
				try {
					users=hs.createQuery(jpql, User.class).setParameter("strt", d1).setParameter("end", d2)
					.setParameter("rl", role1).getResultList();
					tx.commit();
				}catch (HibernateException e) {
					if (tx != null)
						tx.rollback();
					throw e;
				}
		return users;
	}
	

}
