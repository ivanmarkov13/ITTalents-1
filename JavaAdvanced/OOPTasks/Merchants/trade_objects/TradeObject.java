package trade_objects;

import java.util.ArrayList;

public abstract class TradeObject {
	private String address;
	private String workingHours;
	private double size;
	private ArrayList<Product> products;

	
	public TradeObject(String address, String workingHours, double size) {
		this.address = address;
		this.workingHours = workingHours;
		this.size = size;
		products = new ArrayList<>();
		
	}

	public abstract int getTax();
	
	public void addProducts(ArrayList<Product> products) {
		this.products=products; //dobavqme produkti kum turgovskiq obekt
	}
	
	public  ArrayList<Product> getProducts() {
		return this.products;
	}

	
	
	

	

}
