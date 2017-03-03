package shop;

public class Demo {
	public static void main(String[] args) {
		
		Shop fantastiko = new Shop("Fantastiko", "Sofia", 100);
		Product pileshkoMeso = new ProductPerKG("Pileshko meso", 10, 20);
		Product pueshkoMeso = new ProductPerKG("Pueshko meso", 15, 15);
		Product svinskoMeso = new ProductPerKG("Svinsko meso", 11, 30);
		Product teleshkoMeso = new ProductPerKG("Teleshko meso", 18, 18);
		Product zaeshkoMeso = new ProductPerKG("Zaeshko meso", 20, 10);
		Product konsko = new ProductPerKG("Konsko meso", 20.5, 8);
		Product sirene = new ProductPerKG("Krave sirene", 9.00, 40);
		
		Product bira = new ProductPerPiece("Bira 2l", 2.5, 30);
		Product eggs = new ProductPerPiece("Qitsa 12br", 2.20, 25);
		
		fantastiko.addProducts(pileshkoMeso);
		fantastiko.addProducts(pueshkoMeso);
		fantastiko.addProducts(svinskoMeso);
		fantastiko.addProducts(teleshkoMeso);
		fantastiko.addProducts(zaeshkoMeso);
		fantastiko.addProducts(konsko);
		fantastiko.addProducts(sirene);
		fantastiko.addProducts(bira);
		fantastiko.addProducts(eggs);
		
		
		Customer pesho = new Customer("Petur Petrov",fantastiko, 100, 5);
		Customer gosho = new Customer("Georgi Georgiev", fantastiko, 20, 3);
		
		pesho.addProduct(pueshkoMeso, 3);
		pesho.addProduct(eggs, 2);
		pesho.removeProduct(pueshkoMeso, 1);
		pesho.addProduct(bira, 3);
		System.out.println();
		fantastiko.printInfoForShop();
		System.out.println();
		pesho.payAtCashDesk();
		System.out.println();
		fantastiko.printInfoForShop();
		System.out.println();
		pesho.printInfoForCustomer();
		
		
		
		
	}

}
