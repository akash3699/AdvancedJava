package dao;

import pojos.Course;
import org.hibernate.*;
import static utils.HibernateUtils.*;

import java.util.List;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public String launchNewCourse(Course c) {
		// HS
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			// c ---transient
			hs.persist(c); // c-- persistent
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return "Course launched with ID " + c.getCourseId();
	}

	@Override
	public Course getCourseDetails(String courseName) {
		Course c = null; //doesn't exist
		String jpql = "select c from Course c where c.name=:nm";
		// HS
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			c = hs.createQuery(jpql, Course.class).setParameter("nm", courseName).getSingleResult();
			//c --persistent
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return c;//c -- detached
	}

	@Override
	public Course getCourseNStudentDetails(String courseName) {
		Course c = null; //doesn't exist
		String jpql = "select c from Course c left outer join fetch c.students where c.name=:nm";
		// HS
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			c = hs.createQuery(jpql, Course.class).setParameter("nm", courseName).getSingleResult();
			//c --persistent
		/*	//access the size of a collection
			c.getStudents().size();//select query on students
*/			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return c;//c -- detached

	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> l1=null;
		String jpql = "select c from Course c";
		//HS
		Session hs=getSf().getCurrentSession();
		//tx
		Transaction tx=hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, Course.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	
		return l1;
	}
	
	

}
