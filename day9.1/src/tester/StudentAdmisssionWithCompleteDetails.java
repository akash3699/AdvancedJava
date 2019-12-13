package tester;

import org.hibernate.*;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import pojos.Address;
import pojos.AdharCard;
import pojos.Course;
import pojos.EducationQualification;
import pojos.Student;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StudentAdmisssionWithCompleteDetails {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in);) {
			System.out.println("Enter course name n student's name n email");

			StudentDaoImpl dao = new StudentDaoImpl();
			String cName = sc.next();
			Student s = new Student(sc.next(), sc.next());
			System.out.println("Enter student adress ci st co ph");
			Address a = new Address(sc.next(), sc.next(), sc.next(), sc.next());
			// establish bi-dir asso --helper method
			s.addAddress(a);
			// accept adhar card dtls
			System.out.println("Enter adhar card dtls no city dt");
			AdharCard card = new AdharCard(sc.next(), sc.next(), sdf.parse(sc.next()));
			// link adhar card with a student
			s.setCard(card);
			for (int i = 0; i < 3; i++) {
				System.out.println("Enter type yr gpa of edu qualification ");
				EducationQualification e = new EducationQualification(sc.next(), sc.nextInt(), sc.nextDouble());
			    s.getQualifications().add(e);
			}
			System.out.println(dao.admitNewStudent(cName, s));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
