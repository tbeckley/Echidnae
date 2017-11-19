package packagee;
import java.util.ArrayList;
import java.io.*;

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
	
	
	public static void main(String[] args) throws Exception {
		
	}
}


