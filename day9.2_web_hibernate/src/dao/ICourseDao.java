package dao;

import java.util.List;

import pojos.Course;

public interface ICourseDao {
	String launchNewCourse(Course c);
	Course getCourseDetails(String courseName);
	Course getCourseNStudentDetails(String courseName);
	List<Course> getAllCourses();
	List<String> getAllCourseNames();
}
