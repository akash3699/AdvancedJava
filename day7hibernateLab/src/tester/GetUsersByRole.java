package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.VendorDao;

public class GetUsersByRole {

	public static void main(String[] args) {
		
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter begin date , end date ,role");
			VendorDao dao = new VendorDao();
			dao.getUsersByRole().forEach(o -> System.out.println("Name : " + o[0] + " Count " + o[1]));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
