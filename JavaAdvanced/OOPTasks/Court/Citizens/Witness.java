package Citizens;

public class Witness extends Citizen implements Askable {

	public Witness(String name) {
		super(name, "Witness");
	}

	@Override
	public void answer() {
		System.out.println("I haven't seen anything!");
		
	}

}
