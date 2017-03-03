package Citizens;

import java.util.HashSet;

import juror.Lawyer;

public class Defendant extends Citizen implements Askable{//obvinqem

	private HashSet<Lawyer> lawyers;
	
	public Defendant(String name) {
		super(name,"Defendant");
		this.lawyers=new HashSet<>();
		
	}

	public HashSet<Lawyer> getLawyers() {
		return lawyers;
	}

	public void setLawyers(HashSet<Lawyer> lawyers) {
		this.lawyers = lawyers;
	}

	@Override
	public void answer() {
		System.out.println("I am innocent!");
		
	} 
	
	

}
