package juror;

public class Judge extends Juror {

	public Judge(String name,int experience) {
		super(name,"Judge");
		this.setExperience(experience>=5?experience:5);
	}
	
	

}
