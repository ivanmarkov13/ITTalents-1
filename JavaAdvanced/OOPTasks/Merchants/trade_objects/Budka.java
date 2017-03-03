package trade_objects;

import java.util.ArrayList;

public class Budka extends TradeObject implements IChainTO, IETTO {

	public Budka(String address, String workingHours, double size) {
		super(address, workingHours, (size>=2&&size<=6?size:5));
		
	}

	@Override
	public int getTax() {
		return 50;
	}

}
