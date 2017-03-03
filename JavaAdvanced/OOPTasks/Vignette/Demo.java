package Vignette;

import java.util.ArrayList;
import java.util.Random;

public class Demo {

	public static void main(String[] args) {
		
	GasStation Shell = new GasStation();	
	ArrayList<Driver> drivers = new ArrayList<>();
	drivers.add(new Driver("Pesho", 200, Shell));
	drivers.add(new Driver("Gosho", 100, Shell));
	drivers.add( new Driver("Mitko", 500, Shell));
	drivers.add( new Driver("Stamat", 1000, Shell));
	drivers.add( new Driver("Ivan", 700, Shell));
	drivers.add( new Driver("Niki", 650, Shell));
	drivers.add( new Driver("Kiro", 1200, Shell));
	drivers.add( new Driver("Koceto", 900, Shell));
	drivers.add( new Driver("Vasko", 740, Shell));
	drivers.add( new Driver("Svetli", 1400, Shell));
	
	ArrayList<Vehicle> vehicles = new ArrayList<>();
	for (int i = 0; i < 100; i++) {
		switch(new Random().nextInt(3)) {
			case 0:
				vehicles.add(new Car());
				break;
			case 1:
				vehicles.add(new Truck());
				break;
			case 2:
				vehicles.add(new Autobus());
				break;
		}
		
	}
	
	//for each driver add vehicles from the list with vehicles and remove the vehicles from that list
		for (Driver driver : drivers) {
			for (int i = 9; i >= 0; i--) {
				driver.addVehicles(vehicles.remove(i));
			}
		}
		
	// every third driver buys 5 random vignettes for random duration 
	for (int i = 0; i < drivers.size(); i++) {
		if(i%3==0) {
			for (int j = 0; j < 5; j++) {
				int r = new Random().nextInt(3); //random for duration
				Vignette.Duration duration = (r==0?Vignette.Duration.ANNUAL:(r==1?Vignette.Duration.MONTHLY:Vignette.Duration.DAILY));
				drivers.get(i).buyVignette(new Random().nextInt(drivers.get(i).getVehicles().size()), duration); //random index for vehicle from driver's list of vehicles
			}
		}
		//every other driver buys vignettes for all his vehicles
		else {
			drivers.get(i).buyVignettesForAllVehicles();
		}
		drivers.get(i).printInfo();
		
		}
	
	}
}