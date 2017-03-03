package Vignette;

import Vignette.Vignette.AutoType;

public class Truck extends Vehicle {
	
	public Truck() {
		super(AutoType.TRUCK);
	}
	
	@Override
	public String toString() {
		return "Truck: " + super.toString();
	}

}
