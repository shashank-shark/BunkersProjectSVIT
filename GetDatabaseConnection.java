
import java.sql.*;

public class GetDatabaseConnection {
	/*
	 * global variable section.
	 */
	private String url;
	private String user="cse";
	private String pass="Cse@1998";
	
	private Connection myCon;
	
	public Connection getMyConnection(String dataBaseName) {
		
		/* First i am going to create database */
		
		String sqlCreate = "create database if not exists totallist";
		String useDatabase = "use totallist";
		
		/* Now create table totallist and i am going to create the table for the first time*/
		String createIsPresent = "create table ispresent (tablepresent int)";
		String insertIsPresent = "insert into ispresent(tablepresent) values (0)";
		
		/* at last i am going to set the value of tablepresent to 1 */
		
		
//		Now start creating the actual tables 
		
		/* Creating students table */
		String createStudents = "create table students (usn varchar(20), name varchar(20), email varchar(20), phone varchar(20), primary key (usn))";
				
		/* create tabel attendinfo */
		String createAttendInfo = "create table attendinfo (usn varchar(20),name varchar(20),nhours int,email varchar(20),primary key (usn))";
		
		/* create table shortagelist */
		String createShortageList = "create table shortagelist (usn varchar(20), name varchar(20), percent float, primary key (usn))";
		
		/* create table mailsent */
		String createMailSent = "create table mailsent (usn varchar(20))";
		
		/* create table temp */
		String createTemp = "create table temp (usn varchar(20),name varchar(20))";
		
		/* Now update the values as we created the tables */
		String updateTablepresent = "update ispresent set tablepresent=1 where tablepresent=0";
		
		
		
	
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