package utils;

import java.sql.*;

public class DBUtils {
	public static Connection getConnection() throws Exception {
		// load JDBC drvr
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/test_dac", "kdac", "kdac");
	}

}