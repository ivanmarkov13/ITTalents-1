package Restaurant;

import java.util.ArrayList;
import java.util.Comparator;

import client.Client;

public class Restaurant {
	
	private String name;
	private String address;
	private double money;
	private Menu menu;
	private ArrayList<Server> servers;
	
	//create a restaurant with pre-added items in the menu
	public Restaurant(String name, String address, int money, ArrayList<Server> servers) {
		this.name = name;
		this.address = address;
		this.money = money;
		this.servers = servers;
		menu = new Menu();
		menu.addMeal(new Salad("Shopska",400,10));
		menu.addMeal(new Salad("Ovcharska",300,10));
		menu.addMeal(new Salad("Caprese",500,10));
		menu.addMeal(new MainMeal("Musaka",400,10));
		menu.addMeal(new MainMeal("Bob s nadenitsa",400,10));
		menu.addMeal(new MainMeal("Pile s oriz",500,10));
		menu.addMeal(new Dessert("Biskvitena torta",200,10));
		menu.addMeal(new Dessert("Krem-karamel",100,10));
		menu.addMeal(new Dessert("Palachinka sus shokolad",150,10));
		menu.addBeverages(new AlcoholicBeverage("Bira",20));
		menu.addBeverages(new AlcoholicBeverage("Whiskey",20));
		menu.addBeverages(new AlcoholicBeverage("Vodka",20));
		menu.addBeverages(new AlcoholicBeverage("Konyak",20));
		menu.addBeverages(new AlcoholicBeverage("Rakiya",20));
		menu.addBeverages(new NonAlcoholicBeverage("Mineralna voda",20));
		menu.addBeverages(new NonAlcoholicBeverage("Coca-cola",20));
		menu.addBeverages(new NonAlcoholicBeverage("Fanta",20));
		menu.addBeverages(new NonAlcoholicBeverage("Kafe",20));
		menu.addBeverages(new NonAlcoholicBeverage("Chai",20));
		menu.addBeverages(new NonAlcoholicBeverage("Sprite",20));

	}
	
	public Menu getMenu() {
		return menu;
	}

	public void addMoney(double money) {
		this.money+=money;
	}
	
	public void accommodateClient(Client c) {
		System.out.println("A new client has come to the restaurant.");
	}

	public ArrayList<Server> getServers() {
		return servers;
	}
	
	public void printInfoForMoney() {
		System.out.println("The money of the restaurant is " + this.money);
	}
	
	//find out which is the server with the biggest tip
	public void printInfoForBestServer() {
		double maxTips=0;
		Server best = servers.get(0);
		for (Server server : servers) {
			if(server.getTips()>maxTips) {
				maxTips = server.getTips();
				best = server;
			}
		}
		
		System.out.println("The server with the biggest tips is " + best.getName() + " with " + maxTips);
	}
	
	//sort servers by their tips
	public void sortServers () {
		servers.sort(new Comparator<Server>() {
			@Override
			public int compare(Server o1, Server o2) {
				if (o2.getTips()>o1.getTips()) {
					return 1;
				} 
				if (o2.getTips()<o1.getTips()) {
					return -1;
				}
				return 0;
			}
		});
		
		for (Server server : servers) {
			System.out.println(server.toString());
		}
	}
	
}
