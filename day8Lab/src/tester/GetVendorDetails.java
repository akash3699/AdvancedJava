package tester;
import org.hibernate.*;

import dao.VendorDaoImpl;

import static utils.HibernateUtils.*;

import java.util.Scanner;

public class GetVendorDetails {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();
				Scanner sc = new Scanner(System.in))
		{
			VendorDaoImpl v1 = new VendorDaoImpl();
			System.out.println("Enter Email Id ");
			System.out.println(v1.getVendorDetails(sc.next()));
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
