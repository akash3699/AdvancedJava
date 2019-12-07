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
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	
	public CandidateDaoImpl() throws Exception {
		// get cn from DBUtils
				cn = getConnection();
				// pst for validation
				pst1 = cn.prepareStatement("select * from candidate order by votes DESC LIMIT 2");
				pst3 = cn.prepareStatement("select * from candidate order by votes DESC");
				pst2 = cn.prepareStatement("update candidate set votes=votes+1 where id=?");
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
	public List<Candidates> getAllCandidatesParty() throws Exception {
		List<Candidates> l1 = new ArrayList<>();
			try (ResultSet rst = pst3.executeQuery()) {
				
				while (rst.next())
				{
					Candidates c1 = new Candidates(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4));
					l1.add(c1); 
				}
				
			}
			return l1;
		
	}
	public boolean updateVotesCandidate(int cid) throws Exception {
		this.pst2.setInt(1, cid);
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
