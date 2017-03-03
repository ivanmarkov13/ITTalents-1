package Cases;

import java.util.HashSet;

import Citizens.Accuser;
import Citizens.Defendant;
import Citizens.Witness;
import Court.Court;
import juror.Prosecutor;

public class CriminalCase extends Case {

	public CriminalCase(Defendant defendant, Prosecutor prosecutor,HashSet<Witness>witnesses) {
		super(defendant, prosecutor, 13,witnesses);
	}
	
	@Override
	public void serveJustice() {
		((Prosecutor)accuser).increaseCases();
		super.serveJustice();
	}

	@Override
	protected void proceedWithQuestions() {
		for (int i = 0; i < 5; i++) {
			((Prosecutor)accuser).askQuestions(defendant);
		}
		for (Witness witness : witnesses) {
			((Prosecutor)accuser).askQuestions(witness);
			
		}
		
	}

	

}
