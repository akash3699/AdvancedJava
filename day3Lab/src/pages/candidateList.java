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
			HttpSession hs = request.getSession();
			cd1=(CandidateDaoImpl) hs.getAttribute("candidateDao");
			l1=cd1.getAllCandidatesParty();
//			l1.forEach(System.out::println);
			response.setContentType("text/html");
			for (Candidates candidates : l1) {
				pw.write("<form action='casteVote'>");
				pw.write("<input type='radio' name='party' value='"+candidates.getId()+"'> "+candidates.getParty() +"<br>");
//				pw.write("<h3>"+candidates.toString()+"</h3>");
				
				
			}
			pw.write("<input type=\"submit\" value=\"Cast Vote\">");
			pw.write("</form>");
			pw.write("<br><br><br><br><a href='logout'>Logout</a>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("in doGet candidate list",e);
		}
	}

}
