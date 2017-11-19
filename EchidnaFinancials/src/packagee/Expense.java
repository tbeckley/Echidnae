package packagee;

public class Expense {
	String name;
	float cost;
	
	public Expense(String name, float cost) {
		this.name = name; this.cost = cost;
	}
	
	public String getName() {
		return this.name;
	}
	public float getCost() {
		return this.cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
}
