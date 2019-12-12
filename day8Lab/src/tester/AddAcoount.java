package tester;
import org.hibernate.*;

import dao.BankAccountDaoImpl;
import pojos.AcType;
import pojos.BankAccount;

import static utils.HibernateUtils.*;

import java.util.Scanner;

public class AddAcoount {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();
				Scanner sc = new Scanner(System.in);
				)
		{
			BankAccountDaoImpl bad= new BankAccountDaoImpl();
			System.out.println("Enter VendorId, Account type(SAVING,CURRENT,FD,LOAN) and Balance ");
			System.out.println(bad.createAccount(sc.nextInt(), new BankAccount(AcType.valueOf(sc.next().toUpperCase()), sc.nextDouble())));;
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
