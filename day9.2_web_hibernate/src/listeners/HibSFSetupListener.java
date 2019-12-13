package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.HibernateUtils;

/**
 * Application Lifecycle Listener implementation class HibSFSetupListener
 *
 */
@WebListener
public class HibSFSetupListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public HibSFSetupListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	HibernateUtils.getSf().close();//DB CP cleaned up.
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
        System.out.println("in ctx inited");
        HibernateUtils.getSf();//SF ---hib frmwork is loaded on strt up @ appln dep time
    }
	
}
