package Demo;

import java.util.ArrayList;
import java.util.Random;

import clients.Apartment;
import clients.Buyer;
import clients.House;
import clients.Apartment.ApartmentType;
import clients.Apartment.ConstructionType;
import clients.House.HouseType;
import clients.Plot;
import clients.Plot.PlotType;
import clients.Seller;
import realEstateAgency.Agency;

public class Demo {
	public static void main(String[] args) {
		
		
		Agency agency = new Agency("Talants Enterprize", "Infinity tower", "0883545454");
		
		ArrayList<Seller> prodavachi = new ArrayList<>();
		ArrayList<String> names = new ArrayList<>();
		names.add("Gosho");
		names.add("Pesho");
		names.add("Ivan");
		names.add("Mariika");
		names.add("Stamat");

		ArrayList<String> description = new ArrayList<>();
		description.add("exclusive");
		description.add("special price");
		description.add("furnished");
		description.add("comes with woman");
		description.add("quiet neighbourhood");
		
		
		for (int i = 0; i < 30; i++) {
			int random = new Random().nextInt(100);
			int randomPriceForApartment = new Random().nextInt(150_000)+70_000;
			int randomPriceForHouse = new Random().nextInt(80_000)+50_000;
			int randomPriceForPlot = new Random().nextInt(85_000)+30_000;
			int randomHouseType = new Random().nextInt(HouseType.values().length);
			int randomApartmentType = new Random().nextInt(ApartmentType.values().length);
			int randomPlotType = new Random().nextInt(PlotType.values().length);
			int randomConstructionType = new Random().nextInt(ConstructionType.values().length);
			int randomName = new Random().nextInt(names.size());
			int randomDescription = new Random().nextInt(description.size());
			int randomSize = new Random().nextInt(120) + 30;
			boolean inRegulation = new Random().nextBoolean();

			
			if (random < 33) {
				prodavachi.add(new Seller(names.get(randomName), "088534678" + i, new Apartment(ApartmentType.values()[randomApartmentType], ConstructionType.values()[randomConstructionType], description.get(randomDescription), "Sofia", randomPriceForApartment, randomSize),agency));
			}
			else {
				if (random < 66) {
					prodavachi.add(new Seller(names.get(randomName), "08863627" + i, new House(HouseType.values()[randomHouseType],  ConstructionType.values()[randomConstructionType], description.get(randomDescription), "Sofia", randomPriceForHouse, randomSize),agency));
				}
				else {
					prodavachi.add(new Seller(names.get(randomName), "08836563" + i, new Plot(PlotType.values()[randomPlotType], inRegulation, description.get(randomDescription), "Sofia", randomPriceForPlot, randomSize),agency));
				}
			}
			
		}
		
		
		//3.
		
		for (Seller seller : prodavachi) {
			seller.registerEstate(agency);
			
		}
		
		ArrayList<Buyer> kupuvachi = new ArrayList<>();
		
		//4.
		for (int i = 0; i < 10; i++) {
			int randomMoney = new Random().nextInt(150_000)+30_000;
			int randomName = new Random().nextInt(names.size());
			kupuvachi.add(new Buyer(names.get(randomName), "08362847"+i, randomMoney,agency));
		}
		//5.
		for (Buyer buyer : kupuvachi) {
			buyer.makeRequest();
		}
		//6.
		for (Buyer buyer : kupuvachi) {
			for (int i = 0; i < 3; i++) {
				buyer.makeRequestForView();
			}
		}
		//7.
		for (Buyer buyer : kupuvachi) {
			buyer.makeRequestForPurchase();
			
		}
		
		//8.
		agency.printInfoForMoney();
		
		//9.
		agency.printInfoForAgents();
		
		
	}

}
