package packagee;

import java.sql.*;
import java.util.Date;
import java.util.ArrayList;

public final class ScoreClass 
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
			Date currentDate = new Date();
			java.sql.Timestamp timestamp = new java.sql.Timestamp(currentDate.getTime());
			System.out.println("Current Date: "+currentDate);
			ps.setTimestamp(1, timestamp);
			ps.setString(2, s.UserName);
			ps.setInt(3, (int)s.Score);
				
	    	ps.execute();
	    }
	    catch (Exception e){}
	}
	
	public static ArrayList<ScoreModel> GetHighScores(final int n)
	{
		ArrayList<ScoreModel> scores = new ArrayList<ScoreModel>();
		try
		{
			String query="SELECT * FROM HighScores ORDER BY Score DESC LIMIT "+n;
			
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while (rs.next()) 
			{
				ScoreModel sc = new ScoreModel();
				sc.Score = Long.parseLong(rs.getString("Score"));
				sc.UserName = rs.getString("Username");
				scores.add(sc);
			}
		}
		catch(Exception e)
		{
			System.out.println("There was an error: "+e);	
		}
		return scores;
	}
	
}