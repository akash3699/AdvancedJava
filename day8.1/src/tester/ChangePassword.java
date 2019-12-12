package tester;

import org.hibernate.*;

import dao.UserDaoImpl;

import static utils.HibernateUtils.*;

import java.util.Scanner;

public class ChangePassword {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter email , pwd , new pwd");
			// dao inst
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println(dao.changePassword(sc.next(), sc.next(), sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
