package trade_objects;

public class Mall extends TradeObject implements IChainTO {

	public Mall(String address, String workingHours, double size) {
		super(address, workingHours, (size>=10&&size<=100?size:50));
	}

	@Override
	public int getTax() {
		return 150;
	}

}
