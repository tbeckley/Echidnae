import java.sql.*;
import java.util.Date;
import java.util.List;

public final class DebugClass 
{	
	private static String myDriver;
	private static String myUrl;
	private static Connection conn;
	private static Statement st;
	
	static
	{
		try
		{
			myDriver = "org.gjt.mm.mysql.Driver";
			myUrl = "jdbc:mysql://18.216.91.170/EchidnaApp?useSSL=false";
			conn = DriverManager.getConnection(myUrl, "teb", "thomas");
			Class.forName(myDriver);
			st = conn.createStatement();
		} catch(Exception e){};
	}
	
	public static void SaveGame(final ScoreModel s)
	{	
		try
		{
			String query = "INSERT INTO HighScores(timeScored,Username,Score) VALUES(?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDate(1,  java.sql.Date.valueOf(java.time.LocalDate.now()));
			ps.setString(2, s.UserName);
			ps.setInt(3, (int)s.Score);
				
	    	ps.execute();
	    	
	      st.close();
	    }
	    catch (Exception e){}
	}
	
	public static List<ScoreModel> GetHighScores(final int n)
	{
		List scores = new List<ScoreModel>();
		try
		{
			String query="SELECT * FROM HighScores ORDER BY Score LIMIT ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, n);
			
			ResultSet rs = st.executeQuery(ps);
			ResultSetMetaData rsmd = resultSet.getMetaData();
			
			int columnsNumber = rsmd.getColumnCount();
			while (resultSet.next()) {
			    for (int i = 1; i <= columnsNumber; i++) {
			        if (i > 1) System.out.print(",  ");
			        String columnValue = resultSet.getString(i);
			        System.out.print(columnValue + " " + rsmd.getColumnName(i));
			    }
			    System.out.println("");
			}
		}
		catch(Exception e)
		{
			
		}
		return scores;
	}
	
}