package listeners;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.app.sunbeam.Tutorial;

/**
 * Application Lifecycle Listener implementation class TutSetUpListener
 *
 */
@WebListener
public class TutSetUpListener implements ServletContextListener {

    

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         System.out.println("in ctx initiated");
//         create map of tuts and add it under ctx scope
         HashMap<String, List<Tutorial>> allTuts = new HashMap<>();
         List<Tutorial> l1 = Arrays.asList(new Tutorial("abc", LocalDate.parse("2019-01-01"), "Servlet LifeCycle"),
        		 new Tutorial("abc1", LocalDate.parse("2019-11-21"), "Page Navigation"),
        		 new Tutorial("abc2", LocalDate.parse("2018-12-01"), "Session Tracking"));
         allTuts.put("servlets", l1);
         
         List<Tutorial> l2 = Arrays.asList(new Tutorial("abc", LocalDate.parse("2019-01-01"), "Jsp LifeCycle"),
        		 new Tutorial("abc1", LocalDate.parse("2000-11-21"), "Jsp Action"),
        		 new Tutorial("abc2", LocalDate.parse("2017-12-01"), "Jsp Using JavaBean"));
         allTuts.put("jsp", l2);
         
         List<Tutorial> l3 = Arrays.asList(new Tutorial("abc", LocalDate.parse("2015-01-01"), "Collection Frameworks Basics"),
        		 new Tutorial("abc1", LocalDate.parse("2012-11-21"), "Linked List"),
        		 new Tutorial("abc2", LocalDate.parse("2011-12-01"), "Managing Maps"));
         allTuts.put("coll_frmwork", l3);
         System.out.println(allTuts);
         arg0.getServletContext().setAttribute("all_tuts", allTuts);
    }
	
}
