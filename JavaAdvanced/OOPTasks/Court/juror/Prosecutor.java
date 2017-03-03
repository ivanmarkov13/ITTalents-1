package juror;

import Citizens.IAccuser;

public class Prosecutor extends Juror implements IAccuser {

	public Prosecutor(String name,int experience) {
		super(name,"Prosecutor");
		this.setExperience(experience>=10?experience:10);
		
	}

}
