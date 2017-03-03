package clients;

import realEstateAgency.Agency;
import realEstateAgency.Agent;

public abstract class Client {
	
	protected String name;
	protected String phone;
	protected Agent agent;
	protected Agency agency;
	protected int money;
	
	
	public Client(String name, String phone,Agency agency) {
		super();
		this.name = name;
		this.phone = phone;
		this.agency = agency;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	
	
	
	

}
