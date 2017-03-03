package shop;

public class Shop {
	
	private String name;
	private String address;
	private double money;
	private Product[] products;
	private int addedProducts=0;
	
	
	public Shop(String name, String address, int numberOfProducts) {
		if (name !=null) { 
			this.name = name;
		}
		else {
			this.name = "Shop";
		}
		if (this.address != null) {
			this.address = address;
		}
		else {
			this.address = "Vitosha";
		}
		
		if (numberOfProducts>0) {
			this.products = new Product[numberOfProducts];
		}
	}
		
	public void addProducts(Product p) {
		if(addedProducts<products.length) {
			products[addedProducts++] = p;
		}
		
	}
	
	public Product[] getProducts() {
		return products;
	}

	public void printInfoForShop () {
		System.out.println(this.name + "'s products: ");
		System.out.println();
		for (int i = 0; i < products.length; i++) {
			if(products[i]!= null) {
				products[i].printInfo();
				System.out.println("--------------");
			}
		}
		System.out.println(this.name + "'s money: " + this.money);
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	public double getMoney() {
		return this.money;
	}
	
	
}
	
	
