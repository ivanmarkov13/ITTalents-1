package Vignette;

import Vignette.Vignette.AutoType;

public class Autobus extends Vehicle {
	
	public  Autobus() {
		super(AutoType.BUS);
		}

	@Override
	public String toString() {
		return "Autobus: " + super.toString();
	}
}
