package tester;

import org.hibernate.*;

import dao.UserDaoImpl;

import static utils.HibernateUtils.*;

public class GetAllUserDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf()) {
			UserDaoImpl dao = new UserDaoImpl();
			dao.getAllUsers().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
