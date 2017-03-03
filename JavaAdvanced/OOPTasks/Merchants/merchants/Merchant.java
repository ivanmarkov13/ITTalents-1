package merchants;
import java.util.ArrayList;
import java.util.Random;
import suppliers.Supplier;
import trade_objects.Product;

public abstract class Merchant {
	public final static int NADCENKA=30; // konstanta za nadcenkata
	private String name;
	private String address;
	protected int money;
	
	
	public Merchant(String name, String address, int money) {
		this.name = name;
		this.address = address;
		this.money = money;
	}
	
	public String getName() {
		return name;
	}
	public void makeOrder(int money, Supplier supplier) {
		if (money < this.money/2) { //ako podadenite pari ne nadvishavat polovinata ot nalichnite
			int priceCap = 0; //promenliva za max sumata, koqto moje da plati 
			ArrayList<Product> pokupki = new ArrayList<>(); //spisuk s pokupkite
			while (true) {
				Product p = new Product("product", new Random().nextInt(10)+5); //suzdavame random produkt s cena ot 5 do 15lv
				if ((priceCap+p.getPrice())>=money) { //ako priceCap-a + cenata na sledvashtiq produkt nadvishi podadenite pari
					this.money -= priceCap*((100-supplier.getDiscount())/100); //vadim priceCap-a(parite za zakupenite produkti) ot nalicnite pari
					System.out.println(this.name+ " is making an order for " + priceCap);
					break; //i break-vame
				}
				priceCap+=p.getPrice(); // dobavqme cenata na tekushtiq produkt kum priceCap-a
				pokupki.add(p); //dobavqme produkta kum spisuka s produkti
			}
			acceptProducts(pokupki); //turgovecut priema produktite
		}
	}
	
	public void printInfoForMoney () {
		System.out.println(this.name + "'s money is " + this.money);
	}
	protected abstract void acceptProducts(ArrayList<Product> products);
	
	public abstract void collectMoney ();

	public abstract void payTaxes();

	
	
	
}
