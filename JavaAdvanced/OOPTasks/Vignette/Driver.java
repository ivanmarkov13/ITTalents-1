package Vignette;

import java.util.List;
import Vignette.Vignette;
import java.util.Random;

import Vignette.Vignette.Duration;

import java.util.ArrayList;

public  class Driver {
	private String name;
	private List<Vehicle> vehicles;
	private double money;
	private GasStation gasStation;
	
	//create a driver with name, money and gas station
	public Driver(String name, double money, GasStation gasStation) {
		this.name=name;
		this.money=money;
		this.gasStation=gasStation;
		vehicles = new ArrayList<>();
		
	}

	//buy vignette with index for index of vehicle in the list and duration of the vignette
	public void buyVignette(int index, Duration duration) {
		//a new variable that keeps the value of the vignette to buy
		Vignette toBuy = this.gasStation.sellVignette(vehicles.get(index).autoType, duration); //call the method from the gas station with auto type of the given vehicle and duration 
		//check if the driver has enough money
		if(this.money>=toBuy.getPrice()) {
			//set the vignette to the vehicle
			vehicles.get(index).setVignette(toBuy);
			//pay the vignette
			this.money-=toBuy.getPrice();
			this.gasStation.addMoney(toBuy.getPrice());
			System.out.println(this.name + " is buying vignette: " + toBuy.toString());
		}
		else {
			//in case the driver does not have enough money return the vignette 
			this.gasStation.addVignette(toBuy);
		}
		
	}
	
	//a method for buying vignettes for all vehicles
	public void buyVignettesForAllVehicles() {
		//iterate over the list of vehicles
		for (Vehicle vehicle : vehicles) {
			//random duration
			int r = new Random().nextInt(3);
			Duration duration = (r==0?Vignette.Duration.ANNUAL:(r==1?Vignette.Duration.MONTHLY:Vignette.Duration.DAILY));
			Vignette toBuy = this.gasStation.sellVignette(vehicle.autoType, duration);
			if(this.money>=toBuy.getPrice()) {
				vehicle.setVignette(toBuy);
				this.money-=toBuy.getPrice();
				this.gasStation.addMoney(toBuy.getPrice());
				System.out.println(this.name + " is buying vignette - " + toBuy.toString());
			}
			else {
				//in case the driver does not have enough money return the vignette 
				this.gasStation.addVignette(toBuy);
			}
			
		}
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}


	//a method that adds vehicles 
	public void addVehicles(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}
	
	
	public void printInfo() {
		System.out.println(this.name + "'s vehicles");
		for (Vehicle vehicle : this.vehicles) {
			System.out.println(vehicle.toString());
			
		}
		
	}
	

}