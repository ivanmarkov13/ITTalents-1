package wareHouse;

import java.util.Random;

public class Customer {
	
	private Store store;
	
	Customer (Store store) {
		this.store=store;
	}
	
	public void buyProduct() {
		int whichType = new Random().nextInt(3); //random chislo za tipa produkt
		int whichProduct = new Random().nextInt(3); //random chislo za konkreten produkt ot tozi tip
		Product p = store.getProducts()[whichType][whichProduct]; //wzimame tozi produkt ot magazina
		int numberOfProductToBuy = new Random().nextInt(6)+1; // random chislo za kolichestvoto na produkta (ot 1 do 4)
		if (p.getAvailability() >= numberOfProductToBuy) { //ako nalichnostta e po-golqma ili ravna na jelanoto kolichestvo
			p.setAvailability(-numberOfProductToBuy); //namalqvame nalichnostta w magazina
			System.out.println("Customer is buying a product - " + p.getName() + ", " + numberOfProductToBuy + " units.");
		}
		else {		 //ako nqma tolkova edinitsi ot produkta, se izwikva metoda za zarejdane na produkta w magazina  i togava toi se kupuva
			System.out.print("The customer wants to buy - " + p.getName() +  ", " + numberOfProductToBuy + " units. ");
			System.out.println("But there is not enough. He should wait for delivery!");
			store.takeProductFromWareHouse(p);
			p.setAvailability(-numberOfProductToBuy); //namalqvame nalichnostta w magazina
			System.out.println("Customer is buying a product - " + p.getName() + ", " + numberOfProductToBuy + " units.");
		}
	}

}
