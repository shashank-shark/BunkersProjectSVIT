package bunkersprojectsvit;

import java.sql.*;

public class GetDatabaseConnection {
	/*
	 * global variable section.
	 */
	private String url;
	private String user="bunkers";
	private String pass="Shashank@1998";
	
	private Connection myCon;
	
	public Connection getMyConnection(String dataBaseName) {
		/* I am going to fix the constants for password */
		url = dataBaseName;
		
		/* Now get the connection */
		url = "jdbc:mysql://localhost:3306/" + dataBaseName + "?useSSL=false";
		try {
			myCon = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/* Return the connection */
		return myCon;
	}
}
