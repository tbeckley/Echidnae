import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DebugProject {
    
    public static void main(String[] args) {
    	String s="";
    	try
    	{
    		String filePath = new File("").getAbsolutePath();
    		filePath = filePath + "\\..\\resources\\"+"a.txt";
    		System.out.println(filePath);
    		
    		File f = new File(filePath);
	    	Scanner inputFile = new Scanner(f);
	    	
			while(inputFile.hasNext()){ //if there is still something to read
			     s = s.concat(inputFile.next());
			}
			System.out.println(s);
			
			Gson gson = new Gson();
			TaskModel t;
			t = gson.fromJson(s, TaskModel.class);
			System.out.println(t.taskChoices[0].msg);
    	}
    	catch(Exception e)
    	{
    		System.out.println("Exception: "+e);
    	}
    }
}
