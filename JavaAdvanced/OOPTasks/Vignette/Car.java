package Vignette;

import Vignette.Vignette.AutoType;

public class Car extends Vehicle {
	
	public Car() {
		super(AutoType.CAR);
		}
	
	@Override
	public String toString() {
		return "Car: " + super.toString();
	}

}
