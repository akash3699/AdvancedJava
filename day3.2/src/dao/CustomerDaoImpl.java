package dao;

import pojos.Customer;
import java.sql.*;
//import all static members of DBUtils
import static utils.DBUtils.*;

public class CustomerDaoImpl implements ICustomerDao {
	// D.M
	private Connection cn;
	private PreparedStatement pst1;

	// constr
	public CustomerDaoImpl() throws Exception {
		// get cn from DBUtils
		cn = getConnection();
		// pst for validation
		pst1 = cn.prepareStatement("select * from dac_users where email=? and password=?");
		System.out.println("customer dao created....");
	}

	// clean up
	public void cleanUp() throws Exception {
		if (pst1 != null)
			pst1.close();
		System.out.println("customer dao cleaned up");

	}

	@Override
	public Customer validateUser(String email, String pwd) throws Exception {
		// set IN params
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		// exec
		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next())
				return new Customer(rst.getInt(1), email, pwd, rst.getDouble(4), rst.getDate(5), rst.getString(6));

		}
		return null;
	}

}
