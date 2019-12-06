package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Customer;

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
		try (PrintWriter pw = response.getWriter()) {
			// get HS from WC
			HttpSession hs = request.getSession();
			System.out.println("from logout page " + hs.isNew());
			System.out.println("session id " + hs.getId());
			// get customer dtls from HS scope
			Customer c = (Customer) hs.getAttribute("customer_dtls");
			if (c != null) {
				pw.print("<h4> Hello , " + c.getName() + "</h4>");
				pw.print("u have logged out .....");
				// discard session
				hs.invalidate();
			} else {
				pw.print("<h4> SessionTracking Failed : No cookies</h4>");

			}
			pw.print("<h4> <a href='login.html'>Visit Again</h4>");
		}
	}

}
