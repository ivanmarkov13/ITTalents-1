package wareHouse;

public class Store {

	 Product [][] products;
	private Warehouse warehouse;
	
	
	
	Store(Warehouse warehouse) { //vseki magazin se syzdawa sus sklad
		products = new Product[3][3]; //pri suzdavaneto se inicializira masiva ot produkti
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
		this.warehouse=warehouse;
		
	}
	
	public Product [][] getProducts () {
		return this.products;
	}
	
	public void takeProductFromWareHouse(Product p) {// metod za zarejdane na konkreten produkt, kogato klient iska da kupi, no nqma nalichen
		warehouse.giveProductsToStore(p);
}
	
	public void takeProductsFromWareHouse() { //metod za proverka na nalichnite produkti i ako nqma nalicnost za nqkoi produkti, te se zarejdat ot sklada
		for (int i = 0; i < this.products.length; i++) {
			for (int j = 0; j < this.products[i].length; j++) {
				if (products[i][j].getAvailability()<Product.MIN_QUANTITY) //ako nalichnostta e pod minimalniq prag
					warehouse.giveProductsToStore(products[i][j]); //se vika metoda ot classa warehouse za wzimane na stoki
			}
		}
	}
	
}
