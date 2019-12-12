package tester;

import org.hibernate.*;

import dao.UserDaoImpl;
import pojos.UserRole;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class GetSelectedUserData {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter begin date , end date ,role");
			UserDaoImpl dao = new UserDaoImpl();
			dao.getSelectedUserNamesNAmount(sdf.parse(sc.next()), sdf.parse(sc.next()),
					UserRole.valueOf(sc.next().toUpperCase()))
					.forEach(o -> System.out.println("Name : " + o[0] + " reg amt " + o[1]));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
