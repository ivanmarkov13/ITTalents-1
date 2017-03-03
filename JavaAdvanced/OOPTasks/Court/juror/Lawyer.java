package juror;

public class Lawyer extends Juror {

	public Lawyer(String name,int cases) {
		super(name,"Lawyer");
		this.setCases(cases>=10?cases:10);
	}

}
