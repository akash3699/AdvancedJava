package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import pojos.Voter;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			//get cookies
			HttpSession hs = request.getSession();
			System.out.println("from logout page " + hs.isNew());
			System.out.println("session id " + hs.getId());
			Voter c = (Voter) hs.getAttribute("voter_dtls");
			if(c != null)
			{
				
						//found cookie 
						pw.print("<h4> Clnt Details from logout page : " + c.getName()+"</h4>");
						//tell clnt browser --delete a cookie --set max age 0
//						c.setMaxAge(0);//changing state on server
						//add cookie to resp hdr
//						response.addCookie(c);
						hs.invalidate();
						pw.print("<h4> Logged out successfully</h4>");
						
					
			} else {
				pw.print("<h4> SessionTracking Failed : No cookies</h4>");
				
			}
			pw.print("<h4> <a href='login.html'>Visit Again</h4>");
		}
	}

}
