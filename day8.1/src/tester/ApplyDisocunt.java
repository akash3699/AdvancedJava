package tester;

import org.hibernate.*;

import dao.UserDaoImpl;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ApplyDisocunt {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter discount n reg date");
			// dao inst
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println(dao.applyDiscount(sc.nextDouble(), sdf.parse(sc.next())));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
