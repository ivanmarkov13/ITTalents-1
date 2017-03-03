package Restaurant;

public class Dessert extends Meal {

	public Dessert(String name, int weight,int quantity) {
		super(name, 4, (weight>=200 && weight<=300?weight:250), MealType.DESSERT,quantity);
	}

}
