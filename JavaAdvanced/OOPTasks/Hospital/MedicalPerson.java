package hospital;

public abstract class MedicalPerson {
	protected String name;
	protected String phoneNumber;
	protected HospitalWard hospitalWard;

	
	
	public MedicalPerson(String name, String phoneNumber, HospitalWard hospitalWard) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.hospitalWard = hospitalWard;
	}
	
	

}
