package clients;

import realEstateAgency.Agency;
import realEstateAgency.Agent;

public class Seller extends Client {
	
	private Estate imot;
	
	public Seller(String name, String phone,Estate imot,Agency agency) {
		super(name, phone,agency);
		this.imot=imot;
		this.imot.setSeller(this);
		this.money=0;
	}
	
	public void registerEstate (Agency a) {
		Agent agent = a.giveAgent();
		this.imot.setAgent(agent);
		this.agent = agent;
		agent.putClientInList(this);
		a.putEstateInCatalog(this.imot);
		
	}
	
	public void payComission() {
		double komisionna = (double)3/100*this.imot.getPrice();
		this.money+=imot.getPrice()-komisionna;
		this.agency.getMoneyFromDeal(komisionna/2);
		this.agent.setHonorar(komisionna/2);
		System.out.println(this.name + " is paying komisionna for sold estate - " + komisionna);
	}
	

}
