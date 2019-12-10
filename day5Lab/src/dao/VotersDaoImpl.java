package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import static utils.DBUtils.*;
import pojos.Voter;

public class VotersDaoImpl implements IVoterDao
{

	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	
	public VotersDaoImpl() throws Exception {
		// get cn from DBUtils
				cn = getConnection();
				// pst for validation
				pst1 = cn.prepareStatement("select * from voters where email=? and password=?");
				pst2 = cn.prepareStatement("update voters set status=1 where id=?");
				pst3 = cn.prepareStatement("insert into voters (name, email, password, status, role) values(?,?,?,?,?)");
				System.out.println("customer dao created....");
	}

	public Voter authenticateVoter(String email, String pwd) throws Exception {
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		// exec
		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next())
				return new Voter(rst.getInt(1),rst.getString(2), email, pwd, rst.getInt(5),rst.getString(6));

		}
		return null;
		
	}
	public int registerVoter(String name,String email, String pwd,int status, String role) throws Exception {
		pst3.setString(1, name);
		pst3.setString(2, email);
		pst3.setString(3, pwd);
		pst3.setInt(4, status);
		pst3.setString(5, role);
		// exec
		if (pst3.executeUpdate()>0) {
			System.out.println("inserted successfully;");
			return 1;

		}
		return 0;
		
	}
	public boolean updateVoter(int vid) throws Exception {
		this.pst2.setInt(1, vid);
		// exec
		
			int count  = this.pst2.executeUpdate();
			if (count>0)
				return true;

		
		return false;
		
	}

	public void cleanUp() throws Exception {
		// TODO Auto-generated method stub
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		
		
		System.out.println("voter dao cleaned up");
	}

}
