
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
<<<<<<< HEAD
		String createStudents = "create table if not exists students (usn varchar(60), name varchar(60), email varchar(60), phone varchar(60), primary key (usn))";
				
		/* create tabel attendinfo */
		String createAttendInfo = "create table if not exists attendinfo (usn varchar(60),name varchar(60),nhours int,email varchar(60),foreign key (usn) references students (usn) on delete cascade)";
		
		/* create table shortagelist */
		String createShortageList = "create table if not exists shortagelist (usn varchar(60), name varchar(60), percent float, foreign key (usn) references students (usn) on delete cascade)";
		
		/* create table mailsent */
		String createMailSent = "create table if not exists mailsent (usn varchar(60), sentdate date, senttime datetime, foreign key (usn) references students (usn) on delete cascade)";
		
		/* create table temp */
		String createTemp = "create table if not exists temp (usn varchar(60),name varchar(60), foreign key (usn) references students (usn) on delete cascade)";
=======
		String createStudents = "create table if not exists students (usn varchar(20), name varchar(20), email varchar(20), phone varchar(20), primary key (usn))";
				
		/* create tabel attendinfo */
		String createAttendInfo = "create table if not exists attendinfo (usn varchar(20),name varchar(20),nhours int,email varchar(20),primary key (usn))";
		
		/* create table shortagelist */
		String createShortageList = "create table if not exists shortagelist (usn varchar(20), name varchar(20), percent float, primary key (usn))";
		
		/* create table mailsent */
		String createMailSent = "create table if not exists mailsent (usn varchar(20))";
		
		/* create table temp */
		String createTemp = "create table if not exists temp (usn varchar(20),name varchar(20))";
>>>>>>> 0560b61d1abc5362e13eee3c7ce12573709d6b93
		
		/* Now update the values as we created the tables */
		String updateTablepresent = "update ispresent set tablepresent=1 where tablepresent=0";
		
<<<<<<< HEAD
		/* Inserting a trigger here */
//		String delimeter = "DELIMITER //";
//		String createTrigger = "create trigger insert_date_and_time after insert on mailsent for each row ";
//		String beginTrigger = "BEGIN ";
//		String mainAction1 = "set sentdate=CURDATE() ";
//		String mainAction2 = "set senttime=NOW() ";
//		String endTrigger = "END";
		
//		String finalTrigger = "create trigger insert_date_and_time after insert on mailsent for each row begin update mailsent set sentdate=CURDATE(),senttime=NOW() end;";
			
//		triggerBuilder.append(" CREATE TRIGGER insert_associated_inquiry BEFORE UPDATE ON inquiry ");
		
	
		
		
=======
>>>>>>> 0560b61d1abc5362e13eee3c7ce12573709d6b93
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
			
<<<<<<< HEAD
			
			myStat.execute("drop procedure if exists get_no_of_emails");
			
			/* Now create stored procedure in the database */
			myStat.execute("create definer=`cse`@`localhost` procedure `get_no_of_emails`(IN the_usn varchar(20))"+ " begin"+" insert into mailsent (usn,sentdate,senttime) values (the_usn,null,null);"+" end");
			
			
			/* Start creating trigger now */
//			myStat.execute(delimeter);
//			myStat.execute(createTrigger);
//			myStat.execute(beginTrigger);
//			myStat.execute(mainAction1);
//			myStat.execute(mainAction2);
//			myStat.execute(endTrigger);
//			myStat.execute(finalTrigger);
			myStat.execute("DROP TRIGGER IF EXISTS insert_date_and_time");
			myStat.execute("CREATE TRIGGER insert_date_and_time BEFORE INSERT ON mailsent " //
			        + "FOR EACH ROW "//
			        + "BEGIN "//
			        + "set NEW.sentdate=CURDATE(),NEW.senttime=NOW(); "//
			        + "END;");
			
			
			/* trying to create trigger in the database */

=======
>>>>>>> 0560b61d1abc5362e13eee3c7ce12573709d6b93
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