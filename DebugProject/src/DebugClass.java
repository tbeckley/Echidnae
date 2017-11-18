import java.sql.*;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement;

public final class DebugClass
{	
	public DebugClass()
	{
		try
	    {
	      	// create our mysql database connection
	      	String myDriver = "org.gjt.mm.mysql.Driver";
	      	String myUrl = "jdbc:mysql://18.216.91.170/EchidnaApp?autoReconnect=true&useSSL=false";
	      	Connection conn = DriverManager.getConnection(myUrl, "teb", "thomas");
		
	      	// our SQL SELECT query. 
	      	// if you only need a few columns, specify them by name instead of using "*"
	      	String query = "SELECT * FROM Debug";
	
	      	// create the java statement
	      	Statement st = conn.createStatement();
		
	      	// execute the query, and get a java resultset
	      	ResultSet rs = st.executeQuery(DriverManager.getConnection(myUrl, "teb", "thomas"));
		
	      	// iterate through the java resultset
	    	ResultSetMetaData rsmd = rs.getMetaData();
   			System.out.println("querying SELECT * FROM XXX");
   			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) 
			{
				for (int i = 1; i <= columnsNumber; i++) 
				{
					if (i > 1) System.out.print(",  ");
					String columnValue = rs.getString(i);
					System.out.print(columnValue + " " + rsmd.getColumnName(i));
				}
			   System.out.println("");
   			}
	    	st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
  	}
  	
	public static void SaveGame(String name, String score)
	{
		
	}
}