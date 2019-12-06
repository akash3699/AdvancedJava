package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VotersDaoImpl;
import pojos.Voter;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/validate")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VotersDaoImpl dao;

	public void init() throws ServletException {
		// dao instantiate
		try {
			dao = new VotersDaoImpl();
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
			dao.cleanUp();
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
			Voter c = dao.authenticateVoter(request.getParameter("em"), request.getParameter("pass"));

			// not null -- login success -- display success mesg n display user dtls
			if (c == null) {
				// null --invalid login ---err mesg n retry link
				pw.print("<h4>Invalid Login , Pls <a href=login.html>Retry</a></h4>");
			} else {
				//create a cookie to hold validated Voter dtls
				
				System.out.println(c);
				Cookie c1=new Cookie("cust_dtls",c.toString());
				//add a cookie to resp hdr
//				c1.getName();
				response.addCookie(c1);
				//redirect clnt to the category page in the NEXT request
//				String[] status = c.;
//				System.out.println();
				if(c.getStatus() == 0)
				response.sendRedirect("candidateList");
				else
					response.sendRedirect("login.html");
				//rs --- SC 302 / location="category" cookie --nm n value
			}
		} catch (Exception e) {
			// centralized err handling
			throw new ServletException("err in do-get", e);
		}
	}

}
