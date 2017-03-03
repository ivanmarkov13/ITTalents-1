package hospital;

import hospital.Hospital.WardName;

public class Nurse extends MedicalPerson {
	
	private int age;
	private int experience;
	
	public Nurse(String name, String phoneNumber, int age, int experience, HospitalWard hospitalWard) {
		super(name, phoneNumber,hospitalWard);
		this.age = age;
		this.experience = experience;
	}
	
	public void takeCare(Patient p) {
		System.out.println("Nurse " + this.name + " gave medicine " + p.getPlanForTreatment().values() + " to  " + p.getName() + " from room number " + p.getRoomNumber() + " in ward " + p.getHospitalWard());
		
	}
	
	public HospitalWard getHospitalWard() {
		return hospitalWard;
	}
	
	

}
