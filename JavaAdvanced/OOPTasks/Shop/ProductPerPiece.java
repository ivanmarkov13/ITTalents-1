package shop;

public class ProductPerPiece extends Product {
	
	public ProductPerPiece(String name, double price, double availability) {
		super(name, price, availability,false);
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		if (this.getAvailability()==1) {
			System.out.println("piece, " + "availability: " + (int)this.getAvailability() + " piece");
		}
		else {
			System.out.println("piece, " + "availability: " + (int)this.getAvailability() + " pieces");

		}
	}

}
