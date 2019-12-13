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

public class CancelStudentAdmisssion {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in);) {
			System.out.println("Enter student's  email n course name ");

			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println(dao.cancelAdmission(sc.next(), sc.next()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
