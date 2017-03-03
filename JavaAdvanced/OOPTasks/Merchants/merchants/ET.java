package merchants;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

import suppliers.Retailer;
import trade_objects.IETTO;
import trade_objects.Product;

public class ET extends Merchant {

	
	private IETTO etTradeObject;//1
	private ArrayList<Retailer> suppliers; //5
	
	public ET(String name, String address, int money) {
		super(name, address, money);
		suppliers = new ArrayList<>();
	}

	public IETTO getEtTradeObject() {
		return etTradeObject;
	}

	public void setEtTradeObject(IETTO etTradeObjects) {
		this.etTradeObject = etTradeObjects;
	}

	@Override
	protected void acceptProducts(ArrayList<Product> products) {
		etTradeObject.addProducts(products); //dobavqme produktite v turgovskiq obekt
	}

	@Override
	public void collectMoney() {
		int moneyFromAllProducts=0;
		double turnover = 0;
		for (int i = 0; i < etTradeObject.getProducts().size(); i++) { //obhojdame produktite v turgovskiq obekt
			moneyFromAllProducts+= etTradeObject.getProducts().get(i).getPrice(); //sumirame im distributorskite ceni
			
		}
		turnover = (moneyFromAllProducts+(((double)NADCENKA/100)*moneyFromAllProducts));
		this.money+=turnover; //dobavqme kum tekusthite pari na verigata distributorskite ceni+30%nadcenka
		System.out.println(this.getName() + "'s turnover is " + turnover);
	
		}
	

	
	public void payTaxes() {
		int totalTaxesForMonth=0;
		totalTaxesForMonth+=(etTradeObject.getTax()/12); //vzimame danuka za turgosvkiq obekt i go delim na 12
		System.out.println("The total taxes for month for " + this.getName() + " is " + totalTaxesForMonth);
		this.money-=totalTaxesForMonth; //vadim mesechniq danuk ot nalichnite pari
		
	}
}
	

