import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import merchants.Ambulant;
import merchants.ChainStore;
import merchants.ET;
import merchants.Merchant;
import suppliers.Retailer;
import suppliers.Supplier;
import suppliers.WholeSailer;
import trade_objects.Budka;
import trade_objects.IChainTO;
import trade_objects.IETTO;
import trade_objects.Mall;
import trade_objects.Sergia;
import trade_objects.TradeObject;

public class Demo {
	static ArrayList<Supplier> suppliers = new ArrayList<>();

	public static void main(String[] args) {

		
		//1.
		
		for (int i = 0; i < 10; i++) {
			if(new Random().nextBoolean()) {
				suppliers.add(new Retailer());
			}
			else {
				suppliers.add(new WholeSailer());
			}
			
		}
		
		
		//2.
		
		ArrayList<TradeObject> tradeObjects = new ArrayList<>();
		
		for (int i = 0; i < 20; i++) {
			int r = new Random().nextInt(3);
			switch(r) {
			case 0:
				tradeObjects.add(new Sergia("Liulin", "8-17", 6));
				break;
			case 1:
				tradeObjects.add(new Mall("carigradsko", "8-17", 40));
				break;
			case 2:			
				tradeObjects.add(new Budka("jenskiq pazar", "8-17", 5));
				break;
			}
			
		}
		
		Ambulant ambul = new Ambulant("Ambul", "jenski pazar", 100);
		ET et = new ET("ET", "Mall Paradise", 500);
		ChainStore mcDonalds = new ChainStore("McDonalds", "mladost", 3000);
		ArrayList<Merchant> merchants = new ArrayList<>();
		merchants.add(et);
		merchants.add(mcDonalds);
		merchants.add(ambul);
		
		while (true) { //cikul, koito zadawa tyrgovski obekt na ET
			int randIdx = new Random().nextInt(tradeObjects.size());
			if (tradeObjects.get(randIdx) instanceof IETTO) {
				et.setEtTradeObject((IETTO)tradeObjects.get(randIdx));
				tradeObjects.remove(randIdx);
				break;
			}
		}
		int counter=0;
		while (counter<10) { //cikul, koito zadava 10 turgovski obekta na mcDonalds
			int randIdx = new Random().nextInt(tradeObjects.size());
			if (tradeObjects.get(randIdx) instanceof IChainTO) {
				mcDonalds.addTradeObject((IChainTO)tradeObjects.get(randIdx));
				tradeObjects.remove(randIdx);
				counter++;
				}
		}
		
		initiateTrade(merchants);
		for (int i = 0; i < merchants.size(); i++) {
			merchants.get(i).printInfoForMoney();
		
		}
	}
		
		public static void initiateTrade(ArrayList<Merchant> merchants) {
			for (int i = 0; i < merchants.size(); i++) { //purvo se pravi poruchka
				int randIdx = new Random().nextInt(suppliers.size()); //random index za supplier
				int randIdxForMoney;//random index za pari za poruchka
				if((merchants.get(i) instanceof Ambulant || merchants.get(i) instanceof ET) && suppliers.get(randIdx) instanceof Retailer) { //ako turgovecut e instanciq na ambulant ili ET i supplier-a e instanciq na turgovec na drebno
					randIdxForMoney = (new Random().nextInt(150)); 
					merchants.get(i).makeOrder(randIdxForMoney, (Retailer)suppliers.get(randIdx)); //turgovecut pravi poruchka za random pari i kum random supplier-a,koito e retailer
				}
				if (merchants.get(i) instanceof ChainStore) {//ako e chainStore, raboti s vsqkakvi supplier-i i direktno pravi poruchka
					randIdxForMoney = (new Random().nextInt(1000)); 
					merchants.get(i).makeOrder(randIdxForMoney, suppliers.get(randIdx)); 
				}
				merchants.get(i).collectMoney(); // posle se subirat parite 
				if(merchants.get(i) instanceof Ambulant) {
					continue; //ako turgovecut e ambulant, ne plashta danuci
				}
				merchants.get(i).payTaxes(); //nakraq se plashtat danucite
				
			}
			
			
			} // parite na ambulanta pochti vinagi sa 100, zashtoto toi mnogo trudno moje da napravi poruchka,
		//tui kato nalichnite mu pari sa mnogo malko(100), a randomut za stoinost na poruchkata vurti ot 0 do 300,
		//puk stoinostta na poruchkata ne trqbva da nadvishava polovinata ot nalichnite pari(t.e za ambulanta trqbva da e pod 50)
		
	}


