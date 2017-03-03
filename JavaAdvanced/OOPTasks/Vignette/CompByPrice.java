package Vignette;

import java.util.Comparator;

public class CompByPrice implements Comparator<Vignette> {

	@Override
	public int compare(Vignette o1, Vignette o2) {
		return o1.getPrice()-o2.getPrice();
	}
	

}
