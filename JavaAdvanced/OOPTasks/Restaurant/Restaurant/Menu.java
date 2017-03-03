package Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import Restaurant.Beverage.BeverageType;
import Restaurant.Meal.MealType;

public class Menu {
	
	//2 hashmaps for the items - one for meals and one for beverages
	private HashMap<MealType, ArrayList<Meal>> meals;
	private HashMap<BeverageType, ArrayList<Beverage>> beverages;
	
	public Menu() {
		meals = new HashMap<>();
		beverages= new HashMap<>();
	}
	public HashMap<MealType, ArrayList<Meal>> getMeals() {
		return meals;
	}
	
	//add meal to the menu - check if it contains the meal type and add the meal
	public void addMeal(Meal meal) {
		if	(!this.meals.containsKey(meal.getMealType())) {
			this.meals.put(meal.getMealType(), new ArrayList<>());
		}
		this.meals.get(meal.getMealType()).add(meal);
	}
		
	public HashMap<BeverageType, ArrayList<Beverage>> getBeverages() {
		return beverages;
	}
	public void addBeverages(Beverage beverage) {
		if (!this.beverages.containsKey(beverage.getBeverageType())) {
			this.beverages.put(beverage.getBeverageType(), new ArrayList<>());
		}
		this.beverages.get(beverage.getBeverageType()).add(beverage);
	}
	
	public void PrintMenu() {
		System.out.println("Meals:");
		for (Entry<MealType, ArrayList<Meal>> entry : meals.entrySet()) {
			System.out.println(entry.getKey());
			for (Meal meal: entry.getValue()) {
				meal.printInfo();
			}
			
		}
		System.out.println("Beverages:");
		for (Entry<BeverageType, ArrayList<Beverage>> entry : beverages.entrySet()) {
			System.out.println(entry.getKey());
			for (Beverage beverage: entry.getValue()) {
				beverage.printInfo();
			}
			
		}
		
	}

}
