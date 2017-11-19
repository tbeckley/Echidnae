package packagee;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import com.google.gson.Gson;

public class Player {
	String name;
	float balance;
	float income;
	float expenses;
	float assets;
	float liabilities;

	public Player(float balance, float income, float expenses, float assets, float liabilities) {
		this.balance = balance;
		this.income = income;
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

			System.out.println(s);

			tasks.add(new Gson().fromJson(s, TaskModel.class));
		}
		return tasks;
	}

	public void enactChoice(ChoiceModel ch)
	{
		String choice = ch.res;
		String risk = ch.rsk;
	}
	
	public static void main(String[] args) throws Exception {
		ArrayList<TaskModel> tasks = getDayTasks(1);
		for (int i = 0; i < 5; i++) {
			System.out.println("" + tasks.get(i).taskName);
		}
	}

}
