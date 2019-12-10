package beans;

import java.util.List;

import dao.CandidateDaoImpl;
import pojos.Candidates;
import pojos.Voter;

public class CandidateBean {

	//D.M ---properties of Java bean
		private String email,password;
		private CandidateDaoImpl dao;
		private Voter details;//validated cust dtls
		//login status mesg
		private String message;
		//def constr
		public CandidateBean() throws Exception{
			System.out.println("cust bean constr");
			//create dao inst
			dao=new CandidateDaoImpl();
		}
		//setters n getters
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public CandidateDaoImpl getDao() {
			return dao;
		}
		public void setDao(CandidateDaoImpl dao) {
			this.dao = dao;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public  Voter getDetails() {
			return details;
		}
		public void setDetails(Voter details) {
			this.details = details;
		}
		
		public String getMessage() {
			return message;
		}
		//B.L method for customer auth.
		public String getCandidates() throws Exception{
			System.out.println("in B.L auth "+email+" "+password);
			List<Candidates> l1=dao.getAllCandidates();
			if(l1 != null) {
				
				message="Login Successful";
				return "candidateList";
			}
			message="Invalid Login ,Pls Retry";
			return "login";//returning dyn nav outcome to JSP
		}
		
}
