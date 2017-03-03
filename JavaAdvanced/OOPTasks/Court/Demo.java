import java.util.HashSet;

import Cases.Case;
import Cases.CivilCase;
import Cases.CriminalCase;
import Citizens.Accuser;
import Citizens.Citizen;
import Citizens.Defendant;
import Citizens.Witness;
import Court.Court;
import juror.Lawyer;
import juror.Prosecutor;
import juror.Jury;
import juror.Judge;

public class Demo {
	public static void main(String[] args) {
	

	Court strashniqSud = new Court("Sud");
	strashniqSud.judges.add(new Judge("Judge 1",13));
	strashniqSud.judges.add(new Judge("Judge 2", 13));
	strashniqSud.judges.add(new Judge("Judge 3", 11));	
	strashniqSud.jury.add(new Jury("Jury 1"));
	strashniqSud.jury.add(new Jury("Jury 2"));
	strashniqSud.jury.add(new Jury("Jury 3"));
	strashniqSud.jury.add(new Jury("Jury 4"));
	strashniqSud.jury.add(new Jury("Jury 5"));
	strashniqSud.jury.add(new Jury("Jury 6"));
	strashniqSud.jury.add(new Jury("Jury 7"));
	strashniqSud.jury.add(new Jury("Jury 8"));
	strashniqSud.jury.add(new Jury("Jury 9"));
	strashniqSud.jury.add(new Jury("Jury 10"));
	strashniqSud.jury.add(new Jury("Jury 11"));
	strashniqSud.jury.add(new Jury("Jury 12"));
	strashniqSud.jury.add(new Jury("Jury 13"));
	strashniqSud.lawyers.add(new Lawyer("Lawyer 1", 10));
	strashniqSud.lawyers.add(new Lawyer("Lawyer 2", 10));
	strashniqSud.lawyers.add(new Lawyer("Lawyer 3", 10));
	strashniqSud.lawyers.add(new Lawyer("Lawyer 4", 10));
	strashniqSud.lawyers.add(new Lawyer("Lawyer 5", 10));
	strashniqSud.prosecutors.add(new Prosecutor("Prosecutor 1", 10));
	strashniqSud.prosecutors.add(new Prosecutor("Prosecutor 2", 10));
	
	Defendant c1 = new Defendant("Pesho");
	Citizen c2 = new Defendant("Gosho");
	Citizen c3 = new Defendant("Misho");
	Citizen c4 = new Defendant("Chefo");
	Citizen c5 = new Defendant("Naum");
	Accuser c6 = new Accuser("Grigor");
	Accuser c7 = new Accuser("Nikifor");
	Citizen c8 = new Accuser("Anastas");
	Citizen c9 = new Accuser("Prezviter");
	Citizen c10 = new Accuser("Kozma");
	Accuser c11 = new Accuser("Stamat");
	Witness c12 = new Witness("Kiro");
	Witness c13 = new Witness("Denis");	
	Witness c14 = new Witness("Marto");
	Witness c15 = new Witness("Mitko");
	Witness c16 = new Witness("Toni");	
	Witness c17 = new Witness("Koceto");
	Witness c18 = new Witness("Hasan");
	Witness c19 = new Witness("Ibrahim");
	Witness c20 = new Witness("Moni");
	Witness c21 = new Witness("Niki");
	HashSet<Witness> witnesses = new HashSet<>();
	witnesses.add(c12);
	witnesses.add(c13);
	witnesses.add(c14);
	witnesses.add(c15);
	witnesses.add(c16);
	witnesses.add(c17);
	witnesses.add(c18);
	witnesses.add(c19);
	witnesses.add(c20);
	witnesses.add(c21);

	HashSet<Lawyer> defendantLawyers = new HashSet<>();
	HashSet<Lawyer> accuserLawyers = new HashSet<>();
	defendantLawyers.add(new Lawyer("Lawyer 6", 6));
	defendantLawyers.add(new Lawyer("Lawyer 7", 10));
	accuserLawyers.add(new Lawyer("Lawyer 8", 23));
	accuserLawyers.add(new Lawyer("Lawyer 9", 21));
	c1.setLawyers(defendantLawyers);
	c11.setLawyers(accuserLawyers);
	
	Case civil1 = new CivilCase(c1, c11,witnesses);
	civil1.serveJustice();
	strashniqSud.printInfoForJurors();
	
	Case criminal1 = new CriminalCase((Defendant)c3, strashniqSud.prosecutors.get(0), witnesses);
	criminal1.serveJustice();
	strashniqSud.printInfoForJurors();
	
	
	
	
	
	}
	
	
	
	
	
	
	
	}
