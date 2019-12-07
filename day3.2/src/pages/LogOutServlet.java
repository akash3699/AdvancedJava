package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDaoImpl;
import pojos.Book;
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
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// get HS from WC
			HttpSession hs = request.getSession();
			// get customer dtls from HS scope
			Customer c = (Customer) hs.getAttribute("customer_dtls");
			if (c != null) {
				pw.print("<h4> Hello , " + c.getName() + "</h4>");
				//get book dao from HS
				BookDaoImpl dao=(BookDaoImpl)hs.getAttribute("book_dao");
				//get cart from HS
				ArrayList<Integer> cart=(ArrayList<Integer>)hs.getAttribute("shopping_cart");
				//invoke dao's method to get book details for seletcted bks
				double totalPrice=0;
				pw.print("<h3 align='center'>Cart Contents </h3>");
				for(int id : cart)//auto un boxing
				{
					Book b=dao.getBookDetails(id);
					pw.print("<h4>"+b+"</h4>");
					totalPrice += b.getPrice();
				}
				pw.print("<h4>Cart Value "+totalPrice+"</h4>");
				pw.print("u have logged out .....");
				// discard session
				hs.invalidate();
			} else {
				pw.print("<h4> SessionTracking Failed : No cookies</h4>");

			}
			pw.print("<h4> <a href='login.html'>Visit Again</h4>");
		}catch (Exception e) {
			throw new ServletException("err in do-get", e);
		}
	}

}
