package Restaurant;

public class MainMeal extends Meal{

	public MainMeal(String name, int weight,int quantity) {
		super(name, 9, (weight>=400 && weight<=800?weight:600), MealType.MAIN_MEAL,quantity);
	}

}
