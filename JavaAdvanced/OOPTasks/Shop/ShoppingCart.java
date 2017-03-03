package shop;

public class ShoppingCart {
	
	private Product [] products;
	private Customer customer; //dobavqm harakteristika ot tip Customer, zashoto po-nadolu v metoda za premahvane na produkt, iskam da izpolzwam imeto my

	public ShoppingCart(Customer c, int maxItems) {
		if (c != null) {
			this.customer=c;
		}
		if (maxItems > 0) {
			products = new Product[maxItems];
		}
	}
	
	public double calculatePrice () {
		double priceForAllProducts=0; //syzdavame edna promenliva za cenata na vsichki produkti
		for (int i = 0; i < products.length; i++) {
			if(products[i] != null) {
				priceForAllProducts += products[i].calculatePriceForQuantity(); //dobavqme kum cenata na vsichki produkti cenata za vseki produkt po kolichestvoto (tova pravi metoda v klasa produkt)
			}
		}
		return priceForAllProducts;
	}
	
	public void addProductToCart (int addedProducts,Product p, double amount) {
		if(p.isPerKg()) { //ako produktut e na kg, 
			this.products[addedProducts] = new ProductPerKG(p.getName(),p.getPrice(),amount);  //dobavqme nov produkt na kilogram w masiva ot produkti
			System.out.println(customer.getName() + " just added to cart: " + p.getName() + " - " + amount + "kg - and the total sum for shopping is: " + this.calculatePrice());
		}
		else { //ako ne e,
			this.products[addedProducts] = new ProductPerPiece(p.getName(),p.getPrice(),amount);  //dobavqme nov produkt na broika
			System.out.println(customer.getName() + " just added to cart: " + p.getName() + " - " + (int)amount + " pieces - and the total sum for shopping is: " + this.calculatePrice());

		}
	}

	
	public void removeProductFromCart (Product p, double amount) {
		for (int i = 0; i < products.length; i++) { //obikalqme masiva ot produkti
			if(this.products[i] != null && this.products[i].equals(p)){ //ako kletkata na masiva ne e null i produktut v kletkata e raven na podadeniq(po ime)
				if(this.products[i].getAvailability()==amount) { //i ako kolichestvoto na produkta v kolichkata e ravno na podadenoto kolichestvo, koeto iskame da mahnem
					this.products[i] = null; //zanulqvame produkta
				} else 
					if (this.products[i].getAvailability() > amount) { //ako iskame da mahnem samo chast ot kolichestvoto na produkta
						this.products[i].setAvailability(this.products[i].getAvailability()-amount); //namalqvame nalichnostta mu v kolichkata s podadenoto kolichesto
					}
				if(p instanceof ProductPerKG) { // spored zavisi kakuv e produkta kastvam tipa na amount (ako e na kg da si ostane double, ako e na broi - da e int)
					System.out.println(this.customer.getName() + " just removed from cart: " + p.getName() + " - " + amount + "kg -  and the total sum for shopping is: " + this.calculatePrice());
				}
				else {
					System.out.println(this.customer.getName() + " just removed from cart: " + p.getName() + " - " + (int)amount + " piece(s) -  and the total sum for shopping is: " + this.calculatePrice());

				}
			}
		}
	}
	
	public void printInfoForProductsInCart () {
		for (int i = 0; i < products.length; i++) {
			if(products[i] != null) {
				products[i].printInfo();
			}
		}
	}
	
	
}