package tester;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.VendorDao;
import pojos.Vendors;
import pojos.UserRole;

public class RegisterUser {

	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter user details nm em pass ref_amt date role");
			Vendors u1=new Vendors(sc.next(), sc.next(), sc.next(), sc.nextDouble(), sdf.parse(sc.next()), UserRole.valueOf(sc.next().toUpperCase()));
			//invoke dao's method for saving user info
			VendorDao dao=new VendorDao();
			System.out.println(dao.registerVendor(u1));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
