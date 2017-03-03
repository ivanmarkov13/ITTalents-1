package wareHouse;

public class Supplier {
	private int refillUnits=25;

	public void refillProduct(Product product) {
		product.setAvailability(refillUnits); //dostavchikut zarejda suotvetniq produkt s 25 edinitsi
		
		
	}

}
