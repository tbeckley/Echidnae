package packagee;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Player {
	String name;
	float balance;
	float income;
	ArrayList<Expense> expenses;
	float assets;
	float liabilities;
	
	public Player(float balance, float income, float expenses, float assets, float liabilities) {
		this.name = name; this.balance = balance; this.income = income;
		this.assets = assets; this.liabilities = liabilities;
	}
	
	public float getbalance() {
		return this.balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public float getIncome() {
		return this.income;
	}
	public void setIncome(float income) {
		this.income = income;
	}
	public void addExpense(Expense expense) {
		this.expenses.add(expense);
	}
	public void removeExpense(Expense expense) {
		this.expenses.remove(expense);
	}
	public void updateBalance() {
		this.balance = balance + income;
		for(int i = 0; i < expenses.size(); i++) this.balance -= expenses.get(i).cost;
	}
	public boolean nextDay() {
		float totalExpenses = 0;
		for(int i = 0; i < expenses.size(); i++) totalExpenses += expenses.get(i).cost;
		return balance >= totalExpenses;
	}
	public static ArrayList<TaskModel> getDayTasks(final int day)
	{
		ArrayList<TaskModel> tasks = new ArrayList<TaskModel>();
		
		String filePath = new File("").getAbsolutePath();
		filePath = filePath + "\\resources\\day"+day;
		System.out.println(filePath);
		
		File[] listOfFiles = new File(filePath).listFiles();
		
		for(int i = 0; i < listOfFiles.length; i++)
		{
			String s = "";
			try
			{
				Scanner inputFile = new Scanner(listOfFiles[i]);
				
				while(inputFile.hasNext())
					s = s.concat(inputFile.next());
				
				inputFile.close();
			}
			catch(Exception e)
			{
				System.out.println("Could not find file");
			}
			
			System.out.println(s);
			
			Gson gson = new Gson();
			tasks.add(gson.fromJson(s, TaskModel.class));
		}
		return tasks;	
	}
	
	public static void main(String[] args) throws Exception {
		ArrayList<TaskModel> tasks = getDayTasks(1);
		for(int i = 0; i < 5; i++)
		{
			System.out.println(""+tasks.get(i).taskName);
		}
	}
}


