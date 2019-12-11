package tester;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.VendorDao;

public class GetSelectedVendorDetailsOrderByAmount {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter  date ");
			VendorDao dao = new VendorDao();
			dao.getSelectedUsersDetails(sdf.parse(sc.next()))
					.forEach(u -> System.out.printf("Name %s Reg Amount %.1f  Email %s%n", u.getName(), u.getReg_amount(),
							u.getEmail()));
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
