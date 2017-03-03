package Citizens;

import java.util.HashSet;

import juror.Lawyer;

public class Accuser extends Citizen implements IAccuser{ //obvinitel

	private HashSet<Lawyer> lawyers;
	
	public Accuser(String name) {
		super(name,"Accuser");
		this.lawyers= new HashSet<>();
	}

	public HashSet<Lawyer> getLawyers() {
		return lawyers;
	}

	public void setLawyers(HashSet<Lawyer> lawyers) {
		this.lawyers = lawyers;
	}

}
