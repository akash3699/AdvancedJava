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
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// rq -- method=get / cookie hdr.
			pw.print("<h4> Login Successful </h4>");
			// get cookies
			Cookie[] cookies = request.getCookies();
			if (cookies != null) { //no cookies
				for (Cookie c : cookies)
					if (c.getName().equals("cust_dtls"))
						pw.print("<h4> Clnt Details " + c.getValue()+"</h4>");
			} else
				pw.print("<h4> SessionTracking Failed : No cookies</h4>");
			//check out link
			pw.print("<h4><a href='logout'>Log Me Out</a></h4>");


		}
	}

}
