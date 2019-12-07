package pages;

import java.io.IOException;
import java.io.PrintWriter;
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
   
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs = request.getSession();
		cd1=(CandidateDaoImpl) hs.getAttribute("candidateDao");
		vd1= (VotersDaoImpl) hs.getAttribute("voterDao");
		Voter v1= (Voter)hs.getAttribute("voter_dtls");
		response.setContentType("text/html");
		if(!hs.getAttribute("status").equals("voted"))
		{
			try(PrintWriter pw = response.getWriter()) 
			{
				vd1.updateVoter(v1.getId());
				cd1.updateVotesCandidate(Integer.parseInt(request.getParameter("party")));
				
				pw.write("<h3>Successfully Casted Vote</h3>");
				pw.write("<image src='https://img.etimg.com/thumb/msid-69300350,width-300,imgsize-452476,resizemode-4/elections-bccl2.jpg'>");
				pw.write("<br><br><br><br><br><br><h4>Logged Out Successfully</h4>");
				hs.invalidate();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new ServletException("error in doGet voters cast dao ",e);
			}
		}
		else
		{
			try(PrintWriter pw = response.getWriter()) 
			{
				
				pw.write("<h4>You Already Casted Voted </h4>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new ServletException("in doGet candidate list",e);
			}
		}
		
	}

}
