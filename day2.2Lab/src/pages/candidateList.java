package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidateDaoImpl;
import pojos.Candidates;

/**
 * Servlet implementation class candidateList
 */
@WebServlet("/candidateList")
public class candidateList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public List<Candidates> l1 ;
	public CandidateDaoImpl cd1;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			cd1= new CandidateDaoImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("in init candidate list",e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(PrintWriter pw = response.getWriter()) 
		{
			l1=cd1.getAllCandidates();
//			l1.forEach(System.out::println);
			response.setContentType("text/html");
			for (Candidates candidates : l1) {
				pw.write("<h3>"+candidates.toString()+"</h3>");
				pw.write(" ");
			}
			pw.write("<h4> <a href='logout'>Logout</h4>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("in doGet candidate list",e);
		}
	}

}
