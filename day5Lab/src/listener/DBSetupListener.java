package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import static utils.DBUtils.*;

/**
 * Application Lifecycle Listener implementation class ListenerDBUtils
 *
 */
@WebListener
public class DBSetupListener implements ServletContextListener {

   

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	
    	try {
			cleanUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	ServletContext sct = arg0.getServletContext();
    	try {
			setupConnection(sct.getInitParameter("DRIVER"), sct.getInitParameter("URL"), sct.getInitParameter("USERNAME"), sct.getInitParameter("PASSWORD"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	
}
