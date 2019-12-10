package dao;

import java.util.List;

import pojos.Candidates;

public interface ICandidateDao {
	
	public List<Candidates> getAllCandidates() throws Exception;
	public boolean updateVotesCandidate(int cid) throws Exception ;

}
