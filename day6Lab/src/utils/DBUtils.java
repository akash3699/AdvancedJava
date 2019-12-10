package utils;

import java.sql.*;


public class DBUtils {
	private static Connection connection;
	
	
	public static void setupConnection(String DRIVER, String URL,String USERNAME, String PASSWORD) throws Exception {
		// load JDBC drvr
		Class.forName(DRIVER);
		connection =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
	
	public static Connection getConnection() throws Exception {
		
		
		return connection;
	}
	
	public static void cleanUp() throws Exception
	{
		if(connection != null)
			connection.close();
	}
	
}
