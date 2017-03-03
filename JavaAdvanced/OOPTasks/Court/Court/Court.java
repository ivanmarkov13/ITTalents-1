package Court;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

import Cases.Case;
import juror.Judge;
import juror.Jury;
import juror.Lawyer;
import juror.Prosecutor;

public class Court {
	
	private String name;
	public static LinkedList<Judge> judges;
	public static ArrayList<Lawyer> lawyers;
	public static ArrayList<Prosecutor> prosecutors;
	public static LinkedList<Jury> jury;
	public static ArrayList<Case> cases;
	
	public Court(String name) {
		this.name = name;
		this.judges=new LinkedList<>();
		this.lawyers= new ArrayList<>();
		this.prosecutors= new ArrayList<>();
		this.jury = new LinkedList<>();
		this.cases = new ArrayList<>();
	}


	public ArrayList<Case> getCases() {
		return cases;
	}
	
	public void printInfoForJurors() {
		TreeMap<String, Integer> jurorsWithNumberOfCases = new TreeMap<>();
		for (Judge judge : judges) {
			jurorsWithNumberOfCases.put(judge.getName(), judge.getCases());
		}
		for (Lawyer lawyer : lawyers) {
			jurorsWithNumberOfCases.put(lawyer.getName(), lawyer.getCases());
			
		}
		for (Prosecutor prosecutor : prosecutors) {
			jurorsWithNumberOfCases.put(prosecutor.getName(), prosecutor.getCases());
		}
		for (Jury jury : jury) {
			jurorsWithNumberOfCases.put(jury.getName(), jury.getCases());
		}
		System.out.println(jurorsWithNumberOfCases);
	}
}
