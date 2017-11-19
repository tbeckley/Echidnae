package packagee;

import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Player {
	String name;
	float balance;
	float income;
	float expenses;
	float assets;
	float liabilities;
	float shelter;
	float health;

	static Random RNG = new Random();
	
	public Player(float balance, float income, float expenses, float assets, float liabilities) {
		this.balance = balance;
		this.income = income;
		this.expenses = expenses;
		this.assets = assets;
		this.liabilities = liabilities;
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
	public float getExpense() {
		return this.expenses;
	}
	public void setExpense(float expenses) {
		this.expenses = expenses;
	}

	public void updateBalance() {
		this.balance = balance + income - expenses;
	}

	public boolean nextDay() {
		return balance + income >= expenses;
	}

	public static ArrayList<TaskModel> getDayTasks(final int day) {
		ArrayList<TaskModel> tasks = new ArrayList<TaskModel>();

		String filePath = new File("").getAbsolutePath();
		filePath = filePath + "\\resources\\day" + day;
		System.out.println(filePath);

		File[] listOfFiles = new File(filePath).listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			String s = "";
			try {
				Scanner inputFile = new Scanner(listOfFiles[i]);

				while (inputFile.hasNext())
					s = s.concat(inputFile.next());

				inputFile.close();
			} catch (Exception e) {
				System.out.println("Could not find file");
			}

			System.out.println("Task: "+i+" => "+s);

			Gson gson = new GsonBuilder().create();
			TaskModel t = gson.fromJson(s, TaskModel.class);
			tasks.add(t);
		}
		return tasks;
	}

	public void enactChoice(ChoiceModel ch)
	{
		String choice = ch.res;
		String risk = ch.rsk;
		
		String [] chgs = choice.split(",");
		for(int i = 0; i < chgs.length; i++)
			enactChange(chgs[i]);
		
		if(RNG.nextBoolean())
			enactChange(risk);
		
	}
	private void enactChange(String str)
	{
		String varToChange = str.substring(0, Math.max(str.indexOf("+"), str.indexOf("-"))).toLowerCase();
		String chg = str.substring(Math.max(str.indexOf("+"), str.indexOf("-")), str.length());
		
		float c = Float.parseFloat(chg);
		switch(varToChange)
		{
			case "money": balance+=c;
			break;
			case "shelter": shelter+=c;
			break;
			case "health": health+=c;
			break;
			default: System.out.println("Error, invalid type for what to change");
		}
		
	}
	
	public static void main(String[] args) throws Exception {
	}

}
