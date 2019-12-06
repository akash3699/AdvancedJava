package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import dao.VotersDaoImpl;
import pojos.Voter;

/**
 * Servlet implementation class casteVote
 */
@WebServlet("/casteVote")
public class casteVote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public VotersDaoImpl vd1;
       public CandidateDaoImpl cd1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public casteVote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			vd1 = new VotersDaoImpl();
			cd1 = new CandidateDaoImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("error in init voters cast dao ",e);
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
		// TODO Auto-generated method stub
		HttpSession hs = request.getSession();
		Voter v1= (Voter)hs.getAttribute("voter_dtls");
		try(PrintWriter pw = response.getWriter()) 
		{
			vd1.updateVoter(v1.getId());
			cd1.updateVotesCandidate(request.getParameter("party"));
			response.setContentType("text/html");
			pw.write("<h3>Successfully Casted Vote</h3>");
			pw.write("<image src='https://img.etimg.com/thumb/msid-69300350,width-300,imgsize-452476,resizemode-4/elections-bccl2.jpg'>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("error in doGet voters cast dao ",e);
		}
		
	}

}
