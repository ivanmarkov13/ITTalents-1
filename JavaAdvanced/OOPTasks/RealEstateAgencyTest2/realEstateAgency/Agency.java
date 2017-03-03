package realEstateAgency;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

import clients.Estate;
import clients.Estate.EstateType;

public class Agency {
	
	private String name;
	private String address;
	private String phoneNumber;
	private ArrayList<Agent> agents;
	private TreeMap<EstateType, ArrayList<Estate>> catalog; //izbiram tazi kolekciq (s value arrayList), zashtoto ne mojah da izmislq kak inache da moga da obhojdam elementite i da wzimam random imot
	//mojeshe sushto da e hashmap(no ne mislq che ima osobeno znachenie). Ako puk bqh napravila value-to da mi e treeset, shtqha da sa sortirani, no nqmashe da moga da gi obhojdam
	//don't blame me
	private double money;
	
	
	public Agency(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.catalog = new TreeMap<>();
		this.agents = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			agents.add(new Agent("Agent" +(i+1), "088452746" + i));
		}
	}
	
	public Agent giveAgent() {
		int randomAgent = new Random().nextInt(agents.size());
		return agents.get(randomAgent);
	}
	
	public void putEstateInCatalog (Estate e) {
		if(!catalog.containsKey(e.getEstateType())) {
			this.catalog.put(e.getEstateType(), new ArrayList<>());
		}
		this.catalog.get(e.getEstateType()).add(e);
	}
	
	public TreeMap<EstateType, ArrayList<Estate>> getCatalog() {
		for (java.util.Map.Entry<EstateType, ArrayList<Estate>> entry : catalog.entrySet()) {
			entry.getValue().sort((e1,e2)-> {return e1.getPrice()-e2.getPrice();});
		}
		
		//znachi tuk pravq tazi gluposti zashtoto trqbva da e sortiran kataloga, a na men kolekciqta mi e takava
		//che ne gi sortira avtomatichno =_=
		
		return catalog;
	}
	
	public void getMoneyFromDeal (double money) {
		this.money+=money;
	}
	
	public void printInfoForMoney () {
		System.out.println("The agency money is " + this.money);
	}
	
	public void printInfoForAgents () {
		agents.sort((agent1,agent2) -> { return (int)agent2.getHonorar() - agent1.getHonorar();});
		for (Agent agent : agents) {
			System.out.println(agent.toString());
			
		}
	}
	
	public void removeEstateFromCatalogWhenSold(Estate e) {
		this.catalog.get(e.getEstateType()).remove(e);
	}
	
	public void printCatalog() {
		for (java.util.Map.Entry<EstateType, ArrayList<Estate>> entry : getCatalog().entrySet())  {
			System.out.println(entry.getKey());
			for (Estate estate : entry.getValue()) {
				System.out.println(estate);
			};
			
		}
		
	}
	

}
