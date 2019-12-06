package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static utils.DBUtils.*;

import pojos.Candidates;


public class CandidateDaoImpl implements ICandidateDao{

	private Connection cn;
	private PreparedStatement pst1;
	
	public CandidateDaoImpl() throws Exception {
		// get cn from DBUtils
				cn = getConnection();
				// pst for validation
				pst1 = cn.prepareStatement("select * from candidate");
				System.out.println("customer dao created....");
	}

	public List<Candidates> getAllCandidates() throws Exception {
		List<Candidates> l1 = new ArrayList<>();
			try (ResultSet rst = pst1.executeQuery()) {
				
				while (rst.next())
				{
					Candidates c1 = new Candidates(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4));
					l1.add(c1); 
				}
				
			}
			return l1;
		
	}

	public void cleanUp() throws Exception {
		// TODO Auto-generated method stub
		if (pst1 != null)
			pst1.close();
		if (cn != null)
			cn.close();
		System.out.println("voter dao cleaned up");
	}

}
