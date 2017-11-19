/**
 * @(#)DebugProject.java
 *
 * DebugProject application
 *
 * @author 
 * @version 1.00 2017/11/18
 */
 
public class DebugProject {
    
    public static void main(String[] args) {
    	ScoreModel s = new ScoreModel();
    	s.UserName="Thomas";
    	s.Score=20000;
    	DebugClass.SaveGame(s);
    	DebugClass.GetHighScores(10);
    }
}
