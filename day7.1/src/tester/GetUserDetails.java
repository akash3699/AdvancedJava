package tester;
import org.hibernate.*;

import dao.UserDaoImpl;

import static utils.HibernateUtils.*;

import java.util.Scanner;

public class GetUserDetails {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter user id");
			//dao inst
			UserDaoImpl dao=new UserDaoImpl();
			System.out.println(dao.getDetails(sc.nextInt()));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
