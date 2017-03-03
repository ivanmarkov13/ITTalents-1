package Restaurant;

public class Salad extends Meal  {

	public Salad(String name, int weight,int quantity) {
		super(name, 5, (weight>=300 && weight<=600?weight:500), MealType.SALAD,quantity);
	}

}
