package tester;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.VendorDao;

public class GetSelectedVendorDetails {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter begin date ,amount");
			VendorDao dao = new VendorDao();
			dao.getSelectedVendors(sdf.parse(sc.next()),
					sc.nextDouble())
					.forEach(u -> System.out.printf("Name %s Reg Amount %.1f  Date %s%n", u.getName(), u.getReg_amount(),
							u.getReg_date()));
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
