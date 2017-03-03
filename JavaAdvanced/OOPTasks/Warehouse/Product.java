package wareHouse;

public abstract class Product {
	
	private String name;
	private int availability;
	static final int MIN_QUANTITY = 5;
	
	Product (String name) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
		this.availability=15; //purvonachalata nalichnost e 15 po uslovie za vseki produkt
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int amount) { //narochno napravih metoda taka, zashtoto dori nalichnostta da e 0, vinagi moje da podadem 
		this.availability+=amount; //s kolko q uvelichavame ili namalqvame(ako podadenoto chislo e s minus). Po tozi nachin nqam da se nalaga v drug klas, kogato q promenqme da wzimame tekushtata i stoinost i kum neq da dobavqme ili da vadim stoinostt
	}

	public String getName() {
		return this.name;
	}

}
