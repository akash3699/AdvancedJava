package beans;

import java.util.List;

import dao.BankAccountDaoImpl;
import pojos.BankAccount;
import pojos.Vendor;

public class BankAccountBean {
	private int id;
	private List<BankAccount> lb1=null;
	private BankAccountDaoImpl dao = new BankAccountDaoImpl();
	public BankAccountBean() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public List<BankAccount> fetchAccountById()
	{
		return  dao.getAccountById(id);
	}
	public List<BankAccount> getLb1() {
		return lb1;
	}
	public void setLb1(List<BankAccount> lb1) {
		this.lb1 = lb1;
	}

}
