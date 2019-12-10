package beans;


import dao.VotersDaoImpl;
import pojos.Voter;

public class VoterBean {

	//D.M ---properties of Java bean
		
		private String name,role,email,password;
		private int status=0;
		private Voter details;//validated cust dtls
		//login status mesg
		private String message;
		private VotersDaoImpl dao = new VotersDaoImpl();
		//def constr
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
		
		
		
		public VoterBean() throws Exception{
			System.out.println("cust bean constr");
			//create dao inst
			dao=new VotersDaoImpl();
			
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
		public VotersDaoImpl getDao() {
			return dao;
		}
		public void setDao(VotersDaoImpl dao) {
			this.dao = dao;
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
		public String authenticateVoter() throws Exception{
			System.out.println("in B.L auth "+email+" "+password);
			details=dao.authenticateVoter(email, password);
			if(details != null) {
				if(details.getStatus()==0)
				{
					message="Login Successful";
					return "candidateList";
				}
				message="Already Casted the Vote";
				return "status";//returning dyn nav outcome to JSP
			}
			message="Invalid Login ,Pls Retry";
			return "login";//returning dyn nav outcome to JSP
		}
		public String addVoter() throws Exception{
			System.out.println("in B.L auth "+email+" "+password);
			
			if(dao.registerVoter(name,email, password,0,role) > 0) {
				message="Register Successful";
				return "login";
			}
			message="Invalid Login ,Pls Retry";
			return "register";//returning dyn nav outcome to JSP
		}
		public boolean updateVoterStatus() throws Exception
		{
			return dao.updateVoter(details.getId());
		}
}
