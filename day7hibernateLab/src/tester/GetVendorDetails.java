package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.VendorDao;

public class GetVendorDetails {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter user id");
			//dao inst
			VendorDao dao=new VendorDao();
			System.out.println(dao.getDetails(sc.nextInt()));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
