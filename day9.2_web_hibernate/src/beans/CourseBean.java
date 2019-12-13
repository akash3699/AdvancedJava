package beans;

import java.util.List;

import dao.CourseDaoImpl;
import pojos.Course;

public class CourseBean {
	private CourseDaoImpl courseDao;
	public CourseBean() {
		System.out.println("in course bean ctor");
		//dao inst
		courseDao=new CourseDaoImpl();
	}
	//B.L method to return course details
	public List<String> getCourseNames()
	{
		return courseDao.getAllCourseNames();
	}
	

}
