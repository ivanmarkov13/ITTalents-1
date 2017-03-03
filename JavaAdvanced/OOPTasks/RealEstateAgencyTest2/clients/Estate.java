package clients;

import realEstateAgency.Agent;

public abstract class Estate {
	public enum EstateType { APARTMENT, HOUSE, PLOT}
	private EstateType estateType;
	private String description;
	private String address;
	private int price;
	private double size;
	private Agent agent;
	private Seller prodavach;
	
	public Estate(EstateType estateType, String description, String address, int price, double size) {
		this.estateType = estateType;
		this.description = description;
		this.address = address;
		this.price = price;
		this.size = size;
	
	}
	
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
		
	}
	
	
	public Seller getSeller() {
		return prodavach;
	}

	public void setSeller(Seller prodavach) {
		this.prodavach = prodavach;
	}

	public EstateType getEstateType() {
		return estateType;
	}

	public int getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return "Estate [estateType=" + estateType + ", description=" + description + ", address=" + address + ", price="
				+ price + ", size=" + size + ", agent=" + agent + "]";
	}
	
	
	

}
