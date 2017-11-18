
public class Player {
	String name;
	float balance;
	float income;
	float expenses;
	float assets;
	float liabilities;
	
	public Player(String name, float balance, float income, float expenses, float assets, float liabilities) {
		this.name = name; this.balance = balance; this.income = income; this.expenses = expenses;
		this.assets = assets; this.liabilities = liabilities;
	}
	
	public String getName() {
		return this.name;
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
	public float getExpenses() {
		return this.expenses;
	}
	public void setExpenses(float expenses) {
		this.expenses = expenses;
	}
	public void updateBalance() {
		this.balance = balance + income - expenses;
	}

}