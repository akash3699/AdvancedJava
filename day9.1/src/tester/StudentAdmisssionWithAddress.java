package tester;

import org.hibernate.*;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import pojos.Address;
import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StudentAdmisssionWithAddress {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in);) {
			System.out.println("Enter course name n student's name n email");

			StudentDaoImpl dao = new StudentDaoImpl();
			String cName=sc.next();
			Student s=new Student(sc.next(), sc.next());
			System.out.println("Enter student adress ci st co ph");
			Address a=new Address(sc.next(), sc.next(), sc.next(), sc.next());
			//establish bi-dir asso --helper method
			s.addAddress(a);
			System.out.println(dao.admitNewStudent(cName,s ));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
