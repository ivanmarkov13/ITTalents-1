package Vignette;

import java.util.Date;
import java.util.Random;

public class Vignette {
	

	enum AutoType {CAR,TRUCK,BUS};
	enum Duration {ANNUAL,MONTHLY,DAILY};
	
		//each vignette has an auto type and duration
	
	private AutoType autoType;
	private Date issueDate;
	protected int price;
	private String color;
	private Duration duration;
	
	//create a vignette with given autotype and duration
	//the color and the price depend on the autotype and the duration
	public Vignette(AutoType autoType, Duration duration) {
		this.autoType=autoType;
		this.color = (autoType==AutoType.CAR?"pink":(autoType==AutoType.BUS?"green":"blue"));
		this.duration=duration;
		if(this.autoType==autoType.CAR) {
			this.price= (duration==Duration.ANNUAL?300:(duration==Duration.MONTHLY?50:5));
		}
		else {
			if(this.autoType==autoType.TRUCK) {
				this.price= (duration==Duration.ANNUAL?420:(duration==Duration.MONTHLY?70:7));
			}
			else {
				this.price= (duration==Duration.ANNUAL?540:(duration==Duration.MONTHLY?90:9));

			}
		}
		
		
	}
	
	public void putOnWindow() {
		if(this.autoType==autoType.BUS) {
			System.out.println("It's taking 20 seconds...");
		}
		else {
			if (this.autoType==autoType.TRUCK) {
				System.out.println("It's taking 10 seconds...");
			}
			else {
				System.out.println("It's taking 5 seconds..");
			}
		}
	}
	
	public int getPrice() {
		return this.price;
	}
	
	
	public String toString() {
		return "Vignette for : " + this.autoType + ", duration: " + this.duration + ", price: " + this.price;
	}

	
	public Duration getDuration() {
		return this.duration;
	}
	public AutoType getAutoType() {
		return autoType;
	}
	
}
