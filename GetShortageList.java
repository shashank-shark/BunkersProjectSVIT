import java.sql.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/* A simple class to get the wards who have shortage of attendence */

public class GetShortageList {
	public void getShortageList(JTable myTable)
	{
		//first get me the connection
		Connection myCon = new GetDatabaseConnection().getMyConnection("totallist");
		try {
			Statement myStat = myCon.createStatement();
			/* now get the list */
			ResultSet myRes = myStat.executeQuery("select * from shortagelist");
			
			/* Now display the values in the table */
			//first let me get the table model
			DefaultTableModel model = (DefaultTableModel)myTable.getModel();
			int i = 0;
			while (myRes.next()) {
				model.setValueAt(myRes.getString("usn"), i, 0);
				model.setValueAt(myRes.getString("name"), i, 1);
				model.setValueAt(myRes.getFloat("percent"), i, 2);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}