package Cases;

import java.util.HashSet;
import java.util.Random;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import Citizens.Accuser;
import Citizens.Defendant;
import Citizens.IAccuser;
import Citizens.Witness;
import Court.Court;
import juror.Judge;
import juror.Jury;
import juror.Lawyer;

public abstract class Case {
	
	private Judge judge;
	private  HashSet<Jury> jury = new HashSet<>();
	protected Defendant defendant;
	protected IAccuser accuser;
	protected HashSet<Witness>witnesses = new HashSet<>();
	
	public Case(Defendant defendant, IAccuser accuser, int juryNumber, HashSet< Witness> witnesses) {
		this.judge = Court.judges.removeFirst();
		for (int i = 0; i < juryNumber; i++) {
			jury.add(Court.jury.remove(0));
		}
		this.defendant = defendant;
		this.accuser = accuser;
		this.witnesses=witnesses;
	}
	
	public void serveJustice() {
		for (Jury jury : jury) {
			jury.increaseCases();;
		}
		this.judge.increaseCases();;
		this.proceedWithQuestions();
		for (Lawyer lawyer : this.defendant.getLawyers()) {
			lawyer.increaseCases();
			for (Witness witness : witnesses) {
				lawyer.askQuestions(witness);
			}
		}
		int vinoven=0;
		int nevinen=0;
		for (Jury jury2 : jury) {
			boolean isGuilty = new Random().nextBoolean();
			if (isGuilty) {
				vinoven++;
			}
			else {
				nevinen++;
			}
		}
		if(vinoven>this.jury.size()/2) {
			System.out.println("The jury decided that the defendant is guilty!");
			int random = new Random().nextInt(37)+3;
			System.out.println("The judge determined the sentence - " + random + " years.");
		}
		else {
			System.out.println("The jury decided that the defendant is innocent!");
		}

		Court.judges.add(judge);
		for (Jury jury : jury) {
			Court.jury.add(jury);
		}
	}
	
	protected abstract void proceedWithQuestions();

}
