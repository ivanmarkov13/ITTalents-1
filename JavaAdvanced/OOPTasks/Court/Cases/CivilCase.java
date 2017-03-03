package Cases;

import java.util.HashSet;
import java.util.Iterator;

import Citizens.Accuser;
import Citizens.Defendant;
import Citizens.Witness;
import Court.Court;
import juror.Lawyer;

public class CivilCase extends Case {

	public CivilCase(Defendant defendant, Accuser accuser, HashSet<Witness> witnesses) {
		super(defendant, accuser, 3,witnesses);
		
	}

	@Override
	protected void proceedWithQuestions() {
		for (Lawyer l : ((Accuser)accuser).getLawyers()) {
			for (int i = 0; i < 3; i++) {
				l.askQuestions(defendant);
			}
			for (Witness witness : witnesses) {
				for (int i = 0; i < 2; i++) {
					l.askQuestions(witness);
					
				}
				
			}
		}
	}
}


