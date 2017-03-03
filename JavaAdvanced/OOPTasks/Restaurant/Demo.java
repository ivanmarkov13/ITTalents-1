import java.util.ArrayList;
import java.util.Random;

import Restaurant.Beverage;
import Restaurant.Beverage.BeverageType;
import Restaurant.Meal;
import Restaurant.Meal.MealType;
import Restaurant.Restaurant;
import Restaurant.Server;
import client.Client;
import client.Mutra;
import client.Student;
import client.Vegan;

public class Demo {
	public static void main(String[] args) {
		
		//create 5 servers 
		ArrayList<Server>servers = new ArrayList<>();
		servers.add(new Server("Gosho"));
		servers.add(new Server("Ivan"));
		servers.add(new Server("Dragan"));
		servers.add(new Server("Petkan"));
		servers.add(new Server("Marcheto"));

		//create a restaurant with name, address, money and servers
		Restaurant priPesho = new Restaurant("Pri Pesho Talanta", " ", 1000, servers);
		
		
		//create 15 clients (20% vegans, 30%students and and 50% mutri)
		ArrayList<Client> clients = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			int r = new Random().nextInt(100);
			if (r < 20) {
				clients.add(new Vegan(priPesho));
			}
			else {
				if (r < 50) {
					clients.add(new Student(priPesho));
				}
				else {
					clients.add(new Mutra(priPesho));
				}
			}
			
		}
		//initiate work
		initiateWork(priPesho, clients);
		priPesho.printInfoForMoney();
		priPesho.printInfoForBestServer();
		priPesho.sortServers();
		priPesho.getMenu().PrintMenu();
	}

	//restaurant starts working with given clients
	public static void initiateWork (Restaurant r, ArrayList<Client> clients) {
		int i =1; //counter for customers
		//accommodate the clients
		for (Client client : clients) {
			r.accommodateClient(client);
		}
		//each client orders 
		for (Client client : clients) {
			System.out.print("Client " + i++ + " - ");
			MealType mealType;
			BeverageType beverageType;
			//if he's a mutra he can order only main meal and alcohol
			if (client instanceof Mutra) {
				System.out.println("Mutra");
				mealType = MealType.MAIN_MEAL;
				beverageType = BeverageType.ALCOHOLIC;
			}
			else {
				//if he is a vegan he can order only salads and non-alcohol
				if (client instanceof Vegan) {
					System.out.println("Vegan");
					mealType = MealType.SALAD;
					beverageType = BeverageType.NON_ALCOHOLIC;
					
				} else {
					//if he is a student - he can order everything
					//based on random principle choose a meal and beverage type
					System.out.println("Student");
					int mealTypeIndex = new Random().nextInt(3);
					mealType = mealTypeIndex==0?MealType.SALAD:(mealTypeIndex==1?MealType.MAIN_MEAL:MealType.DESSERT);
					int beverageTypeIndex = new Random().nextInt(2);
					beverageType = beverageTypeIndex==0?BeverageType.ALCOHOLIC:BeverageType.NON_ALCOHOLIC;
					
				}
			}
			Meal mealToOrder;
			Beverage beverageToOrder;
			//a cycle that checks if there is enough quantity of the meal to order
			do { //get a new random meal if there is no more of the meal
				int mealIndex = new Random().nextInt(r.getMenu().getMeals().get(mealType).size()); //a index for a random meal
				mealToOrder = r.getMenu().getMeals().get(mealType).get(mealIndex); //get the random meal

			} 
			while (mealToOrder.getQuantity()<=0);
			
			//cycle that checks if there is enough quantity of the beverage to order
			do { //get a new random beverage if there is no more of the beverage to order
				int beverageIndex = new Random().nextInt(r.getMenu().getBeverages().get(beverageType).size()); //a index for a random beverage
				beverageToOrder = r.getMenu().getBeverages().get(beverageType).get(beverageIndex); //get the random beverage
			} 
			while (beverageToOrder.getQuantity()<=0);
			
			//a random server
			Server server = r.getServers().get(new Random().nextInt(r.getServers().size()));
			//client makes order 
			client.makeOrder(mealToOrder, beverageToOrder, server);
			System.out.println();
				
		}
		//client asks for check and pays it
		for (Client client : clients) {
			client.askForCheck();
			client.payCheck();
			
		}
	}
}
