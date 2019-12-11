package tester;

import org.hibernate.*;

import dao.UserDaoImpl;
import pojos.UserRole;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class GetSelectedUserDetails {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter begin date , end date ,role");
			UserDaoImpl dao = new UserDaoImpl();
			dao.getSelectedUsersDetails(sdf.parse(sc.next()), sdf.parse(sc.next()),
					UserRole.valueOf(sc.next().toUpperCase()))
					.forEach(u -> System.out.printf("Name %s Reg Amount %.1f  Date %s%n", u.getName(), u.getRegAmount(),
							u.getRegDate()));
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
