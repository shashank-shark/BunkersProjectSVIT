
import java.sql.*;

public class GetDatabaseConnection {
	/*
	 * global variable section.
	 */
	private String url;
	private String user="cse";
	private String pass="Cse@1998";
	private int flag = 0;
	
	private Connection myCon;
	
	public Connection getMyConnection(String dataBaseName) {
		
		/* First i am going to create database */
		
		String sqlCreate = "create database if not exists totallist";
		String useDatabase = "use totallist";
		/* Now create table totallist and i am going to create the table for the first time*/
		String createIsPresent = "create table if not exists ispresent (tablepresent int)";
		String insertIsPresent = "insert into ispresent(tablepresent) values (0)";
		
		/* at last i am going to set the value of tablepresent to 1 */
		
		
//		Now start creating the actual tables 
		
		/* Creating students table */
		String createStudents = "create table if not exists students (usn varchar(20), name varchar(20), email varchar(20), phone varchar(20), primary key (usn))";
				
		/* create tabel attendinfo */
		String createAttendInfo = "create table if not exists attendinfo (usn varchar(20),name varchar(20),nhours int,email varchar(20),primary key (usn))";
		
		/* create table shortagelist */
		String createShortageList = "create table if not exists shortagelist (usn varchar(20), name varchar(20), percent float, primary key (usn))";
		
		/* create table mailsent */
		String createMailSent = "create table if not exists mailsent (usn varchar(20))";
		
		/* create table temp */
		String createTemp = "create table if not exists temp (usn varchar(20),name varchar(20))";
		
		/* Now update the values as we created the tables */
		String updateTablepresent = "update ispresent set tablepresent=1 where tablepresent=0";
		
		/* I am going to fix the constants for password */
		url = "totallist";
		
		/* Now get the connection */
		url = "jdbc:mysql://localhost:3306/totallist?useSSL=false";
		try {
			myCon = DriverManager.getConnection(url, user, pass);
			System.out.println("Successfully connected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/* Now check whether the database is created or not */
		try {
			Statement myStat = myCon.createStatement();
			/* select the tablepresent from ispresnt */
//			ResultSet myRes = myStat.executeQuery("select * from ispresent");
			myStat.execute(sqlCreate);
			myStat.execute(useDatabase);
			myStat.execute(createIsPresent);
			myStat.execute(insertIsPresent);
			myStat.execute(createStudents);
			myStat.execute(createAttendInfo);
			myStat.execute(createShortageList);
			myStat.execute(createMailSent);
			myStat.execute(createTemp);
			myStat.execute(updateTablepresent);
			
			/* Now check whether the database is created or not */
//			while (myRes.next())
//			{
//				flag = myRes.getInt("tablepresent");
//			}
//			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myCon;
		
//		if (flag == 1)
//		{
			
//		}
//		else
//		{
//			try {
////				Statement myStat = null;
////				myStat.execute(sqlCreate);
////				myStat.execute(useDatabase);
////				myStat.execute(createIsPresent);
////				myStat.execute(insertIsPresent);
////				myStat.execute(createStudents);
////				myStat.execute(createAttendInfo);
////				myStat.execute(createShortageList);
////				myStat.execute(createMailSent);
////				myStat.execute(createTemp);
////				myStat.execute(updateTablepresent);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		
		
		
		/* Return the connection */
	
	}
}