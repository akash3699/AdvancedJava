package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.*;

import pojos.Course;
import pojos.Student;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String admitNewStudent(String courseName, Student s) {
		String jpql = "select c from Course c where c.name = :nm";
		String mesg = "student admission failed";
		// HS
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			Course c = hs.createQuery(jpql, Course.class).setParameter("nm", courseName).getSingleResult();
			// c-- PERSISTENT
			c.addStudent(s);
			mesg="student admission succesful....";
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
