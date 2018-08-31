package bunkersprojectsvit;
import java.sql.*;
/*
 * I need a static file to access all the data members.
 */

public class GetResources {
	
	Connection myCon;
	Statement myStat;
	ResultSet myRes;
	
	/* declare the static members */
	static String usn[] = new String[75];
	static boolean present[] = new boolean[75];
	static int attendedHours[] = new int[75];
	static float percentageAtt[] = new float[75];
	
	/* Now let this file connect to the shortage list database */
	public  void getCurrentStatus(int n)
	{
		int temphours = 0;
		float tempperc = 0.0f;
		
		GetDatabaseConnection conObj = new GetDatabaseConnection();
		try
		{
			myCon = conObj.getMyConnection("totallist");
			myStat = myCon.createStatement();
			myRes = myStat.executeQuery("select * from attendinfo");
			
			/* I think i have successfully retrieved
			 * the values from the shortage list database
			 */
			for (int i = 0; myRes.next() == true; i++)
			{
				//Now increment the number of hours and calculate the percentage
				if (Bunkers_Automated_MS.absentOh[i] != 0)
				{
					temphours = myRes.getInt("nhours");
					temphours = temphours + n;
					myStat = myCon.createStatement();
					myStat.executeUpdate("update attendinfo set nhours="+temphours + " where usn='" +Bunkers_Automated_MS.PresentUsn[i]+"'");
				
				}
				else
				{
					System.out.println(Bunkers_Automated_MS.PresentUsn[i]);
				}
			}
			
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
	}
}
