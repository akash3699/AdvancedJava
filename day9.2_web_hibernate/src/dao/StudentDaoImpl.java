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

	@Override
	public String cancelAdmission(String email, String cName) {
		String mesg="Cancelling admisssion failed";
		String jpql1="select s from Student s where s.email=:em";
		String jpql2="select c from Course c where c.name=:nm";
		//HS
		Session hs=getSf().getCurrentSession();
		//tx
		Transaction tx=hs.beginTransaction();
		try {
			//get student from its email
			Student s =hs.createQuery(jpql1, Student.class).setParameter("em",email).getSingleResult();
			Course c=hs.createQuery(jpql2, Course.class).setParameter("nm", cName).getSingleResult();
			//student n course --valid (s & c --- PERSISTENT)
			c.removeStudent(s);
			mesg="admission cancelled....";
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}
	

}
