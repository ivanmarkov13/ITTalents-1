package shop;


public class Customer {
	
	private String name;
	private Shop fantastiko;
	private double cash;
	private int maxItems;
	private ShoppingCart myCart;
	private int addedProducts=0; //indeks za dobavenite produkti
	
	
	
	public Customer(String name,Shop shop, double cash, int maxItems) {
		if(name != null && !name.isEmpty()) {
			this.name = name;
		}
		if (shop!=null) {
			this.fantastiko = shop;
		}
		if(cash>0) {
			this.cash = cash;
		}
		if (maxItems > 0) {
			this.maxItems = maxItems;
			myCart = new ShoppingCart(this,this.maxItems); //syszdavame nova kolichka 
		}
	}
		
	public String getName() {
		return name;
	}

	public void addProduct (Product p, double amount) { //podavame koi produkt iskame i kakvo kolichestwo
		if (addedProducts < maxItems) { //ako dobavenite produkti sa po-malko ot maksimalniq broi za klienta
			if (amount < p.getAvailability()) { // i iskanoto kolichestvo go ima v magazina
				if((this.myCart.calculatePrice() + (p.getPrice()*amount)) <= this.cash) { //i ako cenata na produktite do momenta + cenata na podadeniq produkt*kolichestvoto ne nadvishava nalichnite pari na klienta
					this.myCart.addProductToCart(addedProducts, p, amount); //dobavqme produkta kum kolichkata
					p.setAvailability(p.getAvailability()-amount); //namalqvame nalichnostta na produkta v magazina
					addedProducts++; //uvelichavame indeksa za dobaveni produkti
					
				}
				else { //w protiven sluchai
					System.out.println("Not enough money for product - " + p.getName() ); //ako ne stigat parite
				}
			}
			else { //ako stigat parite, no jelanoto kolichestvo ne e nalichno
				System.out.println("There is not enough availability in the shop!");
			}
		}
		else {
			System.out.println(this.name + " cannot buy more products!"); //ako stigat parite, no sme nadvishili broikata za produkti na klienta
		}
		
	}
	
	public void removeProduct (Product p,double amount) { //podavame koi produkt iskame da mahnem i kakvo kolichestwo
		this.myCart.removeProductFromCart(p,amount);//mahame produkta kum kolichkata
		p.setAvailability(p.getAvailability()+amount); //uvelichavame kolichestvoto na produkta v magazina s vurnatoto kolichestvo
	}
	
	public void payAtCashDesk() {
		if(myCart.calculatePrice() <= this.cash) { //ako cenata na produktite e po-malka ili ravna na nalichnite pari na klienta
			this.cash-=myCart.calculatePrice(); //vadim sumata ot parite
			this.fantastiko.setMoney(myCart.calculatePrice() + fantastiko.getMoney()); //dobavqme sumata kum oborota na magazina
			System.out.println(this.getName() + " is buying: " );
			this.myCart.printInfoForProductsInCart();
			System.out.println("for " + this.myCart.calculatePrice() + "lv.");
		}
	}
	
	public void printInfoForCustomer () {
		System.out.println(this.name + "'s cash: " + this.cash);
	}
	
	

}	