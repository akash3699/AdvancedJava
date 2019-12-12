package dao;

import pojos.Course;
import org.hibernate.*;
import static utils.HibernateUtils.*;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public String launchNewCourse(Course c) {
		//HS
		Session hs=getSf().getCurrentSession();
		//tx
		Transaction tx=hs.beginTransaction();
		try {
			//c ---transient
			hs.persist(c); // c-- persistent
			tx.commit();
		}catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return "Course launched with ID "+c.getCourseId();
	}

}
