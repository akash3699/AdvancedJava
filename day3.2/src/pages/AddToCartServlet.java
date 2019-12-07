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

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/add_to_cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	response.setContentType("text/html");
		
			//pls un comment to check the exc
/*			pw.print("in add to cart page");
			pw.flush();
*/			//get selected book ids --from request params
			String[] bookIds=request.getParameterValues("bid");
			//get HS
			HttpSession hs=request.getSession();
			//get cart from HS
			ArrayList<Integer> cart=(ArrayList<Integer>)hs.getAttribute("shopping_cart");
			//populate the cart from bids
			for(String s : bookIds)
			 cart.add(Integer.parseInt(s));//auto boxing
			System.out.println("cart "+cart);
			//redirect clnt to category page
			response.sendRedirect("category");
			
		
	}

}
