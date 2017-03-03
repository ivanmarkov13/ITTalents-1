package wareHouse;

public class Warehouse {
	 Product [][] products;
	private Supplier servant;
	
	Warehouse(Supplier servant) {
		products = new Product[3][3];
		products[0] = new Fruit [3];
		products[1] = new Veggie[3]; 
		products[2] = new Meat [3];
		products[0][0] = new Banana();
		products[0][1] = new Apple();
		products[0][2] = new Orange();
		products[1][0] = new Potato();
		products[1][1] = new Eggplant();
		products[1][2] = new Cucumber();
		products[2][0] = new Pork();
		products[2][1] = new Beef();
		products[2][2] = new Chicken();
		
		this.servant=servant;
		
	}
	
	public void loadProducts() { //metod za proverka na nalichnostite v sklada i zarejdane na produkti
		for (int i = 0; i < products.length; i++) {
			for (int j = 0; j < products[i].length; j++) {
				if(products[i][j].getAvailability() < Product.MIN_QUANTITY) { //ako nalichnostta e po-malka ot minimalniq prag
					System.out.println("There is not enough quantity of this product - " + products[i][j].getName() + "in the warehouse.");
					servant.refillProduct(products[i][j]); //dostachikut zarejda suotvetiq produkt
					System.out.println("The product - " + products[i][j].getName() + " has been loaded in the warehouse.");
				}
			}
		}
	}
	
	public void loadProduct(Product p) { // metod za zarejdane na podaden konkreten produkt
		servant.refillProduct(p);
		System.out.println("The product - " + p.getName() + " was just loaded in the warehouse.");
			
				
	}

	public void giveProductsToStore(Product p) { //metod za zarejdane na konkreten produkt w magazina
		for (int i = 0; i < products.length; i++) {
			for (int j = 0; j < products[i].length; j++) {
				if (products[i][j].getName().equals(p.getName())) { //sravnqvame podadeniq produkt(koito e ot magazina) po ime s prodiktite w sklada
					if (products[i][j].getAvailability() > Product.MIN_QUANTITY) { //ako nalichnostta na produkta sus sushtoto ime w sklada e poweche ot minimalniq prag
						products[i][j].setAvailability(-5); //namalqvame nalichnostta na produkta v sklada
						p.setAvailability(+5); //uvelichava nalichnostta mu v magazina 
						System.out.println("The store just loaded this product - " + p.getName());
					}
					else {
						System.out.println("There is not enough " + p.getName() + " in the warehouse.");
						this.loadProduct(products[i][j]); //ako nalichnostta na produkta v sklada e pod praga, se wika metoda za zarejdane na konkreten produkt i sled tova tozi produkt se zarejda i v magazina
						products[i][j].setAvailability(-5); //namalqvame nalichnostta na produkta v sklada
						p.setAvailability(+5); //uvelichava nalichnostta mu v magazina 
						System.out.println("The store just loaded this product - " + p.getName());
					}
				}
				
			}
		}
	}
}
