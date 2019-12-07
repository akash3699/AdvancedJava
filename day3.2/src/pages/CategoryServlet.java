package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDaoImpl;
import pojos.Customer;

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

			pw.print("<h4> Login Successful </h4>");
			// get HS from WC
			HttpSession hs = request.getSession();
			System.out.println("from 2nd page " + hs.isNew());
			System.out.println("session id " + hs.getId());
			// get customer details from HS
			Customer cust = (Customer) hs.getAttribute("customer_dtls");
			// get book dao from HS
			BookDaoImpl bookDao = (BookDaoImpl) hs.getAttribute("book_dao");
			if (cust != null) {
				pw.print("<h4> Hello , " + cust.getName() + "</h4>");
				// invoke dao 's method to get List of categories
				List<String> cats = bookDao.getAllCategories();
				// dyn form generation
				pw.print("<form action='category_dtls'>");
				pw.print("Choose Category : <select name='cat'>");
				for (String s : cats)
					pw.print("<option value=" + s + ">" + s + "</option>");
				pw.print("</select><br>");
				pw.print("<input type=submit value='Choose Category'>");
				pw.print("<input type=submit value='Show Cart' formaction='show_cart'>");
				pw.print("</form>");
			} else
				pw.print("<h4> SessionTracking Failed : No cookies</h4>");
			// check out link
			pw.print("<h4><a href='logout'>Log Me Out</a></h4>");

		} catch (Exception e) {
			throw new ServletException("err in do-get", e);
		}
	}

}
