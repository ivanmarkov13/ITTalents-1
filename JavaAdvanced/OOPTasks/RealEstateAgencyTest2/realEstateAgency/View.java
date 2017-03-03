package realEstateAgency;

import java.time.LocalDate;

import clients.Buyer;
import clients.Estate;

public class View {
	
	private Estate imot;
	private Agent agent;
	private Buyer buyer;
	private LocalDate date;
	public View(Estate imot, Agent agent, Buyer buyer, LocalDate date) {
		super();
		this.imot = imot;
		this.agent = agent;
		this.buyer = buyer;
		this.date = date;
	}
	public Estate getImot() {
		return this.imot;
	}
	
	
	
	

}
