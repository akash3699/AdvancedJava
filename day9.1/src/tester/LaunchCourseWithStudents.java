package tester;

import org.hibernate.*;

import dao.CourseDaoImpl;
import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LaunchCourseWithStudents {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in);) {
			System.out.println("Enter course details name strt  end  capacity fees");
			Course c1 = new Course(sc.next(), sdf.parse(sc.next()), sdf.parse(sc.next()), sc.nextInt(),
					sc.nextDouble());
			//add students to the course
			for(int i=0;i<3;i++)
			{
				System.out.println("Enter student details nm em");
				Student s=new Student(sc.next(), sc.next());
				c1.getStudents().add(s);//adding student dtls to course
			//	System.out.println(s.getSelectedCourse());
				s.setSelectedCourse(c1);//adding course dtls to student
			}
			CourseDaoImpl dao=new CourseDaoImpl();
			System.out.println(dao.launchNewCourse(c1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
