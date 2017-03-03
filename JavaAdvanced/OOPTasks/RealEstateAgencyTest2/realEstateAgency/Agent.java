package realEstateAgency;

import java.util.ArrayList;
import java.util.HashSet;

import clients.Buyer;
import clients.Client;
import clients.Seller;

public class Agent {
	
	private String name;
	private String phoneNumber;
	private int honorar;
	private HashSet<Seller> sellers;
	private HashSet<Buyer> buyers;
	private ArrayList<View> ogledi;
	
	
	public Agent(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.sellers= new HashSet<>();
		this.buyers = new HashSet<>();
		this.ogledi = new ArrayList<>();
		
	}
	
	public void putClientInList(Client c) {
		if(c instanceof Seller) {
			this.sellers.add((Seller)c);
		}
		else {
			this.buyers.add((Buyer)c);
		}
	}

	public void addView(View view) {
		this.ogledi.add(view);
	}
	
	public void setHonorar (double money) {
		this.honorar+=(int)money;
	}
	public int getHonorar() {
		return honorar;
	}

	@Override
	public String toString() {
		return "Agent [name=" + name + ", phoneNumber=" + phoneNumber + ", honorar=" + honorar + "]";
	}
	

}
