package tester;
import org.hibernate.*;

import dao.BankAccountDaoImpl;


import static utils.HibernateUtils.*;

import java.util.Scanner;

public class WithdrawAcoount {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();
				Scanner sc = new Scanner(System.in);
				)
		{
			BankAccountDaoImpl bad= new BankAccountDaoImpl();
			System.out.println("Enter Account id and Amount to Withdraw ");
			System.out.println(bad.withdraw(sc.nextInt(), sc.nextDouble()));
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
