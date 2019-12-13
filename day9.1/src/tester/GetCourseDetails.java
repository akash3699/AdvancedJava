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

public class GetCourseDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in);) {
			System.out.println("Enter course name ");

			CourseDaoImpl dao = new CourseDaoImpl();
			Course c = dao.getCourseDetails(sc.next());//c --detached
			System.out.println("Course details " + c);
//			System.out.println("Students : ");
			/*
			 * for(Student s : c.getStudents()) System.out.println(s);
			 */
			// c.getStudents().forEach(s->System.out.println(s));
	//		c.getStudents().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
