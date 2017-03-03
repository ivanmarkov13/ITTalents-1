package trade_objects;

public class Sergia extends TradeObject implements IETTO{

	public Sergia(String address, String workingHours, double size) {
		super(address, workingHours, (size>=4&&size<=6?size:5));
	}

	@Override
	public int getTax() {
		return 50;
	}

}
