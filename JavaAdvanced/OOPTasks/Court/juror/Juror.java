package juror;

import Citizens.Askable;
import Citizens.Citizen;

public abstract class Juror extends Citizen {
	
	private int experience;
	private int cases;
		
	public Juror(String name,String position) {
		super(name,position);
		this.role=position;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	public void setCases(int cases) {
		this.cases = cases;
	}

	public void askQuestions(Askable koitoGoPitat){
		this.printInfo();
		System.out.print( " asks question to ");
		koitoGoPitat.printInfo();
		System.out.println();
	}
	

	public int getCases() {
		return cases;
	}


	public void takeNotes() {
		this.printInfo();
		System.out.println( " is taking notes..");
		System.out.println();
		
	}
	
	public void increaseCases() {
		this.cases++;
	}

}
