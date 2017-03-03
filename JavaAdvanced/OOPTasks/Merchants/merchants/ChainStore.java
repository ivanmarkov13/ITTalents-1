package merchants;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

import trade_objects.IChainTO;
import trade_objects.Product;

public class ChainStore extends Merchant {
	
	private ArrayList<IChainTO> chainTradeObjects; //10
	private ArrayList<Supplier> suppliers; //15
	
	public ChainStore(String name, String address, int money) {
		super(name, address, money);
		chainTradeObjects = new ArrayList<>(10);
		suppliers = new ArrayList<>(15);
	}
	
	public void addTradeObject(IChainTO tradeObject) {//dobavqme tyrgovski obekt na verigata
		if(chainTradeObjects.size()<10) { 
			chainTradeObjects.add(tradeObject); 
		}
	}

	@Override
	protected void acceptProducts(ArrayList<Product> products) {
		int randomIdx = new Random().nextInt(chainTradeObjects.size()); //izbirame random turgovski obekt 
		chainTradeObjects.get(randomIdx).addProducts(products); //i priemame produktite tam
	}

	@Override
	public void collectMoney() {
		int moneyFromAllProducts=0;
		double turnover = 0;
		for (int i = 0; i < chainTradeObjects.size(); i++) { //za vseki turgovski obekt
			if(chainTradeObjects.get(i).getProducts().size()>0) { //i za vsichki produkti
				for (int j = 0; j < chainTradeObjects.get(i).getProducts().size(); j++) { //vzimame distributorskite ceni
					moneyFromAllProducts+=chainTradeObjects.get(i).getProducts().get(j).getPrice(); //i gi subirame v edna promenliva
					}

				}
			}
			turnover = (moneyFromAllProducts+(((double)NADCENKA/100)*moneyFromAllProducts));
		this.money+=turnover; //dobavqme kum tekusthite pari na verigata distributorskite ceni+30%nadcenka
		System.out.println(this.getName() + "'s turnover is " + turnover);

		
	}
	
	@Override
	public void payTaxes() {
		int totalTaxesForMonth=0;
		for (int i = 0; i < chainTradeObjects.size() ;i++) { //za vsichki turgovski obekti
			totalTaxesForMonth+=(chainTradeObjects.get(i).getTax()/12); //sumirame godishnite danuci,razdeleni na 12
		}
		System.out.println("The total taxes for month for " + this.getName() + " is " + totalTaxesForMonth);
		this.money-=totalTaxesForMonth; //vadim platenite danuci za mesec ot nalichnite pari
		
	}
	
}
