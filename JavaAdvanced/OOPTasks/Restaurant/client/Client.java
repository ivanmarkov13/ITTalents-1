package client;

import java.util.Random;

import Restaurant.Beverage;
import Restaurant.Meal;
import Restaurant.Restaurant;
import Restaurant.Server;

public abstract class Client {
	
	protected double money;
	protected Order order; //a variable of type order
	protected Restaurant restaurant;
	private int tipChance = 80; // there is 80% chance to tip the server

	public Client(int money,Restaurant restaurant) {
		this.money = money;
		this.restaurant=restaurant;
	}
	
	//make order by given meal, beverage and server
	public void makeOrder(Meal meal, Beverage beverage, Server server) {
		//create a new order to the given server
		order = new Order(server);
		//check if the price of the meal is more than 90% of client's money
		if (meal.getPrice() <= 0.9*this.money) {
			System.out.print("Client is ordering: ");
			meal.printInfo();
			//if not - add the meal to the order and reduce its quantity in the restaurant
			this.order.addProducts(meal);
			meal.reduceQuantity();
		}
		else {
			System.out.print("Not enough money for this meal- ");
			meal.printInfo();
		}
		
		//check if the value of the current order(which includes the ordered meal) plus the beverage price is more than 90%of client's money
		if (this.order.getValue() + beverage.getPrice() <= 0.9*this.money) {
			System.out.print("Client is ordering: ");
			beverage.printInfo(); 
			//if not add the beverage to the order and reduce its quantity
			this.order.addProducts(beverage);
			beverage.reduceQuantity();
		}
		else {
			System.out.print("Not enough money for this beverage - ");
			beverage.printInfo();
		}
		
	}
	
	public void askForCheck() {
		System.out.println("The client asked for the check - " + order.getValue() + "lv. ") ;
	}

	//pay the check and calculate the chance to tip
	public void payCheck() {
		System.out.print("The client is paying the check - " + order.getValue() + "lv. ");
		double tip = 0;
		//if the random is a number between 0 and 80 tip the server
		if (new Random().nextInt(100) < tipChance) {
			//a boolean random for deciding either 10 or 5 % from the order value for tip
			boolean bigTip = new Random().nextBoolean();
			tip = bigTip?0.1*this.order.getValue():0.05*this.order.getValue();
			System.out.print("Tip - " + tip);
		}
		System.out.println();
		System.out.println();
		//reduce the client's money,increase the restaurant's money and the server's money from tips
		this.money-=this.order.getValue();
		this.restaurant.addMoney(this.order.getValue());
		this.money-=tip;
		this.order.getServer().addTips(tip);
		
		
	}
	

}
