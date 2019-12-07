package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import static utils.DBUtils.*;

/**
 * Application Lifecycle Listener implementation class DBSetupListener
 *
 */
@WebListener
public class DBSetupListener implements ServletContextListener {

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("in ctx destroyed");
		try {
			cleanUp();//cn closing
		} catch (Exception e) {
			System.out.println("err in ctx destroyed " + e);
		}
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ctx inited");
		// set up DB connection , by passing ctx params
		// get servlet ctx from event obj
		ServletContext ctx = arg0.getServletContext();
		//getting ctx params
		String drvrCls = ctx.getInitParameter("drvr_class");
		String dbURL = ctx.getInitParameter("db_url");
		String uName = ctx.getInitParameter("user_name");
		String pwd = ctx.getInitParameter("password");
		try {
			setUpConnection(drvrCls, dbURL, uName, pwd);
		} catch (Exception e) {
			System.out.println("err in ctx inited " + e);
		}
	}

}
