package Vignette;


import java.util.Date;

import Vignette.Vignette.AutoType;

public abstract class Vehicle {
	
	private String model;
	private Vignette vignette;
	private Date dateOfManufacture;
	protected AutoType autoType;
	
	//create a vehicle with auto type
	public Vehicle(AutoType autoType) {
		this.autoType = autoType;
	}
	public Vignette getVignette() {
		return vignette;
	}
	
	//set a vignette
	public void setVignette(Vignette vignette) {
		this.vignette=vignette;
	}
	@Override
	public String toString() {
		if (vignette!=null) {
		return "[Has a " + vignette + "]";
		}
		else {
			return "no vignette";
		}
	}
	
	

	
	
	

}
