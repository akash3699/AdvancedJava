package beans;

import java.util.ArrayList;
import java.util.List;

import dao.CandidateDaoImpl;
import pojos.Candidates;
import pojos.Voter;

public class CandidateBean {

	//D.M ---properties of Java bean
		
		private CandidateDaoImpl dao;
		private Candidates details;//validated cust dtls
		public void setDetails(Candidates details) {
			this.details = details;
		}
		private String party;
		
		public String getParty() {
			return party;
		}

		public void setParty(String party) {
			this.party = party;
		}
		private List<Candidates> list;
		public List<Candidates> getList() {
			return list;
		}

		public void setList(List<Candidates> list) {
			this.list = list;
		}
		//login status mesg
		private String message;
		//def constr
		public CandidateBean() throws Exception{
			System.out.println("cust bean constr");
			//create dao inst
			dao=new CandidateDaoImpl();
			list= new ArrayList<Candidates>();
		}
		//setters n getters
		
		public CandidateDaoImpl getDao() {
			return dao;
		}
		public void setDao(CandidateDaoImpl dao) {
			this.dao = dao;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
		public String getMessage() {
			return message;
		}
		
		public List<Candidates> getAllParties() throws Exception
		{
			list =dao.getAllCandidatesParty();
			return list;
		}
		//B.L method for customer auth.
		public String getCandidates() throws Exception{
			
			List<Candidates> l1=dao.getAllCandidates();
			if(l1 != null) {
				
				message="Login Successful";
				return "candidateList";
			}
			message="Invalid Login ,Pls Retry";
			return "login";//returning dyn nav outcome to JSP
		}
		
		public boolean updateVotes() throws Exception
		{
			System.out.println("in candidate update votes");
			return dao.updateVotesCandidate(party);
		}
		
}
