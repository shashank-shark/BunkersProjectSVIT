package bunkersprojectsvit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NotPresentToday {
	
	//global variables declared here
	Connection myCon;
	Statement myStat;
	ResultSet myRes;
	
	int k = 0;
	
	public NotPresentToday(boolean notPresent[]) {
		/* first establish a connection to the database */
		GetDatabaseConnection connObj = new GetDatabaseConnection();
		myCon = connObj.getMyConnection("totallist");
		
		/* Now create a statement */
		try {
			myStat = myCon.createStatement();
			for (int i = 0; i < 75; i++)
			{
				if (notPresent[i] == true)
				{
					// i.e i am going to insert the data into for 
					// the students present.
					myStat.executeUpdate("insert into temp(usn,name) values('"+Bunkers_Automated_MS.notPresentUsn[k]+"','"+Bunkers_Automated_MS.notPresentName[k]+"')");
//					System.out.println("insert into temp(usn,name) values('"+Bunkers_Automated_MS.notPresentUsn[k]+"','"+Bunkers_Automated_MS.notPresentName[k]+"')");
					k++;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
