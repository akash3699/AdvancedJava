package dao;

import pojos.Voter;

public interface IVoterDao {
	public Voter authenticateVoter(String email, String pwd) throws Exception ;
}
