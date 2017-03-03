package Restaurant;


public abstract class Meal implements Ordable {
	
	public enum MealType {SALAD,MAIN_MEAL,DESSERT};
	
	private String name;
	private int price;
	private int weight;
	private int quantity;
	private MealType mealType;
	
	public Meal(String name, int price, int weight, MealType mealType,int quantity) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.mealType = mealType;
		this.quantity=quantity;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void printInfo() {
		System.out.println(this.mealType + ": " + this.name + ", " + this.price + "lv, quantity: " + this.quantity + " porcii.");
	}
	 public int getQuantity() {
			return quantity;
	}
	 
	 //a method that reduces the quantity when client orders a meal
	 public void reduceQuantity() {
		 this.quantity--;
	 }

	public MealType getMealType() {
		return mealType;
	}
}
