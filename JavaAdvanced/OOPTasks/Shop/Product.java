package shop;

public abstract class Product {
	
	private String name;
	private double price;
	private double availability;
	private boolean isPerKg; //buleva promenliva, koqto da sledi dali produkta e na kg ili na broika
	
	
	public Product(String name, double price,double availability,boolean isPerKg) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
		if (price > 0) {
			this.price = price;
		}
		if (availability > 0) {
			this.availability = availability;
		}
		this.isPerKg=isPerKg;
	}
	
	
	public boolean isPerKg() {
		return isPerKg;
	}


	public double getAvailability() {
		return availability;
	}


	public boolean equals (Product p) { //metod equals, koito sravnqva po imena na produktite
		if (this.getName().equals(p.getName())) {
			return true;
		}
		return false;
	}

	public void setAvailability(double availability) {
		this.availability = availability;
	}


	public void printInfo () {
		System.out.print(this.name + ", price:" + this.price + "lv/");
	}

	public double getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double calculatePriceForQuantity() {
		return this.getPrice()*this.getAvailability();
	}
}
