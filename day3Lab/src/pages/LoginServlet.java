package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import dao.VotersDaoImpl;
import pojos.Voter;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/validate")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VotersDaoImpl dao1;
	private CandidateDaoImpl dao2;

	public void init() throws ServletException {
		// dao instantiate
		try {
			dao1 = new VotersDaoImpl();
			dao2 = new CandidateDaoImpl();
		} catch (Exception e) {
			// re throw the exception to WC to specify init has failed
			// centralized err handling in servlets
			throw new ServletException("err in init", e);

		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			// invoke dao's cleanUp
			dao1.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set resp cont type
		response.setContentType("text/html");
		// open PW
		try (PrintWriter pw = response.getWriter()) {
			// read req params
			// invoke dao's validateUser for validation
			HttpSession hs=request.getSession();
			hs.setAttribute("voterDao", dao1);
			hs.setAttribute("candidateDao", dao2);
			
			Voter c = dao1.authenticateVoter(request.getParameter("em"), request.getParameter("pass"));

			// not null -- login success -- display success mesg n display user dtls
			if (c == null) {
				// null --invalid login ---err mesg n retry link
				pw.print("<h4>Invalid Login , Pls <a href=login.html>Retry</a></h4>");
			} else {
				//create a cookie to hold validated Voter dtls
				
				System.out.println(c);
				if(c.getRole().equals("admin"))
				{
					response.sendRedirect("Results");
				}
				else {
//				Cookie c1=new Cookie("cust_dtls",c.toString());
//				//add a cookie to resp hdr
////				c1.getName();
//				response.addCookie(c1);
				//redirect clnt to the category page in the NEXT request
//				String[] status = c.;
//				System.out.println();
				
				System.out.println("from 1st page "+hs.isNew());
				System.out.println("session id "+hs.getId());
				hs.setAttribute("voter_dtls", c);
				if(c.getStatus() == 0)
				{
					hs.setAttribute("status", "not");
					response.sendRedirect("candidateList");
				}
				else
				{
					hs.setAttribute("status", "voted");
					response.sendRedirect("casteVote");
//					pw.print("<h4> <a href='login.html'>You already casted the vote</h4>");
				//rs --- SC 302 / location="category" cookie --nm n value
				}
			}}
		} catch (Exception e) {
			// centralized err handling
			throw new ServletException("err in do-get", e);
		}
	}

}
