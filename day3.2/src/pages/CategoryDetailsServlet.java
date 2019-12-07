package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDaoImpl;
import pojos.Book;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/category_dtls")
public class CategoryDetailsServlet extends HttpServlet {
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
			//get selected category from request param
			String category=request.getParameter("cat");
			pw.print("<h4 align=center> Books Under "+category+" category</h4>");
			// get book dao from HS
			BookDaoImpl bookDao = (BookDaoImpl) hs.getAttribute("book_dao");
			//imvoke dao's method to get book list
			List<Book> books=bookDao.getBooksByCategory(category);
			if (bookDao != null) {
				// dyn form generation
				pw.print("<form action='add_to_cart'>");
				for(Book b : books)
					pw.print("<input type=checkbox name='bid' value="+b.getId()+">"+b+"<br>");
				pw.print("<input type=submit value='Add To Cart'>");
				pw.print("</form>");
			} 

		} catch (Exception e) {
			throw new ServletException("err in do-get", e);
		}
	}

}
