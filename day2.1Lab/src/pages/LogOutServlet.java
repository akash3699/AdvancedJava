package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			Cookie[] cookies=request.getCookies();
			if(cookies != null)
			{
				for(Cookie c : cookies)
					if(c.getName().equals("cust_dtls"))
					{
						//found cookie 
						pw.print("<h4> Clnt Details from logout page : " + c.getValue()+"</h4>");
						//tell clnt browser --delete a cookie --set max age 0
						c.setMaxAge(0);//changing state on server
						//add cookie to resp hdr
						response.addCookie(c);
						pw.print("<h4> Logged out successfully</h4>");
						
					}
			} else {
				pw.print("<h4> SessionTracking Failed : No cookies</h4>");
				
			}
			pw.print("<h4> <a href='login.html'>Visit Again</h4>");
		}
	}

}
