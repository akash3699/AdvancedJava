package dao;

import pojos.Student;

public interface IStudentDao {
	String admitNewStudent(String courseName,Student s);
}
