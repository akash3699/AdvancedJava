package utils;

import java.sql.*;

public class DBUtils {
	private static Connection connection;

	public static void setUpConnection(String drvr, String dbUrl, String userName, String pwd) throws Exception {
		// load JDBC drvr
		Class.forName(drvr);
		connection = DriverManager.getConnection(dbUrl, userName, pwd);
	}
	public static void cleanUp() throws Exception
	{
		if (connection != null)
			connection.close();
	}
	public static Connection getConnection() {
		return connection;
	}
	
	

}
