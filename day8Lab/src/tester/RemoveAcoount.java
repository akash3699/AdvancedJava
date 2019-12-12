package tester;
import org.hibernate.*;

import dao.BankAccountDaoImpl;


import static utils.HibernateUtils.*;

import java.util.Scanner;

public class RemoveAcoount {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();
				Scanner sc = new Scanner(System.in);
				)
		{
			BankAccountDaoImpl bad= new BankAccountDaoImpl();
			System.out.println("Enter VendorId and Account no ");
			System.out.println(bad.closeAccount(sc.nextInt(), sc.nextInt()));
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
