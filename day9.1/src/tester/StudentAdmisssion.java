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

public class StudentAdmisssion {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in);) {
			System.out.println("Enter course name n student's name n email");

			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println(dao.admitNewStudent(sc.next(), new Student(sc.next(), sc.next())));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
