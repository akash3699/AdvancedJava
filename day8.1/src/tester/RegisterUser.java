package tester;

import org.hibernate.*;

import dao.UserDaoImpl;
import pojos.User;
import pojos.UserRole;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RegisterUser {
//(String name, String email, String password, String confirmPassword, UserRole role, double regAmount,
//	Date regDate
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter user details nm em pass cPass role amt dt");
			User u1=new User(sc.next(), sc.next(), sc.next(), sc.next(),UserRole.valueOf(sc.next().toUpperCase()),
					sc.nextDouble(), sdf.parse(sc.next()));
			//invoke dao's method for saving user info
			UserDaoImpl dao=new UserDaoImpl();
			System.out.println(dao.registerUser(u1));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
