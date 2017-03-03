package hospital;

public class MedicalRecord {
	
	private String patientName;
	private int patientAge;
	private String patientNumber;
	private Doctor patientDoctor;
	
	public MedicalRecord(String patientName, int patientAge, String patientNumber) {
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientNumber = patientNumber;
	}

}
