package clients;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

import clients.Estate.EstateType;
import realEstateAgency.Agency;
import realEstateAgency.Agent;
import realEstateAgency.View;


public class Buyer extends Client {
	
	private int money;
	private ArrayList<View> ogledi;
	
	
	public Buyer(String name, String phone, int money,Agency agency) {
		super(name, phone,agency);
		this.money=money;
		this.ogledi = new ArrayList<>();
	}

	public void makeRequest() {
		Agent agent =this.agency.giveAgent();
		this.agent = agent;
		agent.putClientInList(this);
		
		
	}
	
	public void makeRequestForView() {
		TreeMap<EstateType, ArrayList<Estate>> catalog;
		catalog = this.agency.getCatalog();
		
		do {
			int randomType = new Random().nextInt(EstateType.values().length);
			int randomImot = new Random().nextInt(catalog.get(EstateType.values()[randomType]).size());
			Estate imot = catalog.get(EstateType.values()[randomType]).get(randomImot);
			if ((imot.getPrice()+(double)3/100*imot.getPrice()) < this.money) { //proverka dali cenata + komisionnata za agenta ne nadvishavat parite na kupuvacha
				View view = new View(imot, this.agent, this, LocalDate.now());
				this.ogledi.add(view);
				this.agent.addView(view);
				System.out.println(this.name + " napravi ogled na " + imot.toString());
				break;
			}
		}
		while (true);
		
	}
	
	public void makeRequestForPurchase() {
		if (!this.ogledi.isEmpty()) {
			int randomOgled = new Random().nextInt(ogledi.size());
			Estate imotToBuy = ogledi.get(randomOgled).getImot();
			System.out.println(this.name + " is buying " + imotToBuy.toString());
			double komisionna = (double)3/100*imotToBuy.getPrice();
			this.agency.getMoneyFromDeal(komisionna/2);
			this.agent.setHonorar(komisionna/2);
			imotToBuy.getSeller().payComission();
			this.agency.removeEstateFromCatalogWhenSold(imotToBuy); //remove the estate ffrom the catalog when sold
			

		}
	}
}
