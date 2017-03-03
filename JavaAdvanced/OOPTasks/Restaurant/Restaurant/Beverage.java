package Restaurant;

public abstract class Beverage  implements Ordable{

	public enum BeverageType { ALCOHOLIC, NON_ALCOHOLIC};
	
	private BeverageType beverageType;
	private String name;
	private int price;
	private int quantity;
	
	public Beverage(BeverageType beverageType, String name, int price,int quantity) {
		this.beverageType = beverageType;
		this.name = name;
		this.price = price;
		this.quantity=quantity;
	}
	
	public BeverageType getBeverageType() {
		return beverageType;
	}

	public int getQuantity() {
		return quantity;
	}
	 //a method that reduces the quantity when client orders a beverage
	public void reduceQuantity() {
		this.quantity--;
	}

	
	public int getPrice() {
		return this.price;
	}
	
	
	public void printInfo() {
		System.out.println(this.beverageType + ": " + this.name + ", " + this.price + "lv, quantity: " + this.quantity + " broq.");
	}
	
	
}
