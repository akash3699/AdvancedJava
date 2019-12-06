package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidateDaoImpl;
import pojos.Candidates;

/**
 * Servlet implementation class CandidateResults
 */
@WebServlet("/Results")
public class CandidateResults extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try(PrintWriter pw = response.getWriter()) 
		{
			CandidateDaoImpl cd1 = new CandidateDaoImpl();
			List<Candidates> l1 = cd1.getAllCandidates();
			response.setContentType("text/html");
			for(Candidates c : l1)
			{
				pw.write("<h3>"+c.toString()+"</h3>");
			}
			pw.write("<h4><br><br><br><br><a href='login.html'>Logout</a></h4>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("in doGet candidate list",e);
		}
		
	}

}
