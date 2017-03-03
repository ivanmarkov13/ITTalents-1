package merchants;

import java.util.ArrayList;
import java.util.Random;

import suppliers.Retailer;
import trade_objects.Product;

public class Ambulant extends Merchant {
	

	private Retailer supplier;
	private ArrayList<Product> products;

	public Ambulant(String name, String address, int money) {
		super(name, address, money);
		supplier = new Retailer();
		products = new ArrayList<>();
	}

	@Override
	protected void acceptProducts(ArrayList<Product> products) {
		this.products=products; //poneje ambulantut nqma tyrgovski obekt, ima masiv ot produkti
	}

	@Override
	public void collectMoney() {
		int moneyFromAllProducts=0; //promenliva za sumata ot cenite na produktite(distributorskite ceni)
		int turnOver=0; //oborot
		for (int i = 0; i < products.size(); i++) { //obhojdame vsichki produkti
			moneyFromAllProducts+=products.get(i).getPrice(); //sumirame im cenite
		}
		turnOver += (moneyFromAllProducts+(((double)NADCENKA/100)*moneyFromAllProducts)); //oborotut e raven na obshtata cena + 30%nadcenka
		this.money+=turnOver; //dobavqme oborota kum parite na turgovetsa
		System.out.println(this.getName() + "'s turnover is " + turnOver);
	}
	
	@Override
	public void payTaxes() {
		
	}
	
	
	
	
}
