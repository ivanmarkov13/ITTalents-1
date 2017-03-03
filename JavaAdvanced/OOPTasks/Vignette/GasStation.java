package Vignette;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;
import Vignette.Vignette.AutoType;
import Vignette.Vignette.Duration;

public class GasStation {
	
	private int money;

	private TreeMap<AutoType, TreeMap<Duration,ArrayList<Vignette>>> vignettes = new TreeMap<>();
	
	
	//create the gas station with 1000 random vignettes
	public GasStation() {
		ArrayList<Vignette> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			list.add(new Vignette(AutoType.values()[new Random().nextInt(AutoType.values().length)], Duration.values()[new Random().nextInt(Duration.values().length)]));
		}
		
		for (Vignette vignette : list) {
			AutoType type = vignette.getAutoType();
			Duration d = vignette.getDuration();
			if(!vignettes.containsKey(type)) {
				vignettes.put(type, new TreeMap<>());
			}
			if (!vignettes.get(type).containsKey(d)) {
				vignettes.get(type).put(d, new ArrayList<>());
			}
			vignettes.get(type).get(d).add(vignette);
		}
		
		list.sort(new CompByPrice());
		for (Vignette vignette : list) {
			System.out.println(vignette.toString());
		}
	}
	
	
	//sell vignette by given auto type and duration
	public Vignette sellVignette(AutoType autoType, Duration duration) { 
		//remove the sold vignette
		return vignettes.get(autoType).get(duration).remove(0);
	}
	
	
	//a method that adds vignette to the collection (in case the driver doesn't have enough money when he calls the method for buying vignette)
	public void addVignette(Vignette v) {
		this.vignettes.get(v.getAutoType()).get(v.getDuration()).add(v);
	}


	public void addMoney(int money) {
		this.money+=money;
	}

}
