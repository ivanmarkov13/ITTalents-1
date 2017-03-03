package client;

import java.util.ArrayList;

import Restaurant.Ordable;
import Restaurant.Server;

public class Order {
	//each order has value, ordable products(meals and beverages) and a server
	private int value;
	private ArrayList<Ordable> products;
	private Server server;
	
	public Order(Server server) {
		this.server=server;
		value = 0;
		products = new ArrayList<>();
	}
	
	//add product and increase the order value by product's price
	public void addProducts (Ordable product) {
		this.products.add(product);
		this.value+=product.getPrice();
	}
	
	public int getValue() {
		return this.value;
	}
	
	public Server getServer() {
		return server;
	}
	
	
	

}
