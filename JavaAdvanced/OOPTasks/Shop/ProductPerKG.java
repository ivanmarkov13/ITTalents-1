package shop;

public class ProductPerKG extends Product {
	

	public ProductPerKG(String name, double price, double availability) {
		super(name, price,availability, true);
		
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("kg, " + "availability: " + this.getAvailability() + "kg.");
	}

	

}
