package tester;

import org.hibernate.*;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GetAllCourses {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf()) {

			CourseDaoImpl dao = new CourseDaoImpl();
			dao.getAllCourses().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
