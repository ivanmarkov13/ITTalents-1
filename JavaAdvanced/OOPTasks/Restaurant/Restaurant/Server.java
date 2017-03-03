package Restaurant;

public class Server {
	
	private String name;
	private double tips;
	
	public Server(String name) {
		this.name = name;
		tips = 0;
	}
	
	public void addTips(double money) {
		this.tips+=money;
	}
	
	public double getTips() {
		return tips;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Server [name=" + name + ", tips=" + tips + "]";
	}
	

	

}
