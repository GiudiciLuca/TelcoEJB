package telco.entities;

public class Product {
	private String name;
	private int monthlyFee;
	
	public Product(String name, int monthlyFee) {
		this.name = name;
		this.monthlyFee = monthlyFee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(int monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

}
