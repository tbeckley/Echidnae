import java.util.Random;
 
public class DebugProject {
    
    public static void main(String[] args) {
    	boolean save=false;
    	
    	if(save)
    	{
	    	ScoreModel s = new ScoreModel();
	    	s.UserName="Thomas";
	    	Random rng = new Random();
	    	s.Score=Math.abs(rng.nextLong()) % 30000;
	    	DebugClass.SaveGame(s);
    	}
    	DebugClass.GetHighScores(10);
    }
}
