package hospital;

import hospital.Patient.Gender;

public class Demo {
	public static void main(String[] args) {
		
		Hospital bolnica = new Hospital();
	
		Patient pesho = new Patient("Pesho", Gender.MALE, 23, "086847383");
		bolnica.hospitalize(pesho);
		bolnica.startTreatment(pesho);
		bolnica.printInfoForDoctors();
		bolnica.printInfoForEmptyBeds();
		
		Patient gosho = new Patient("Gosho", Gender.MALE, 45, "03628483");
		bolnica.hospitalize(gosho);
		bolnica.startTreatment(gosho);
		bolnica.printInfoForEmptyBeds();
		bolnica.printInfoForDoctors();
		bolnica.dischargePatient(pesho);
		bolnica.dischargePatient(gosho);
		bolnica.printInfoForDoctors();
		bolnica.hospitalize(new Patient("Ivan", Gender.MALE, 19, "03628483"));
		bolnica.hospitalize(new Patient("Petkan", Gender.MALE, 25, "03628483"));
		bolnica.hospitalize(new Patient("Dragan", Gender.MALE, 34, "03628483"));
		bolnica.hospitalize(new Patient("Kolio", Gender.MALE, 65, "03628483"));
		bolnica.hospitalize(new Patient("Maria", Gender.FEMALE, 26, "03628483"));
		bolnica.hospitalize(new Patient("Ivo", Gender.MALE, 38, "03628483"));
		bolnica.hospitalize(new Patient("Petya", Gender.FEMALE, 45, "03628483"));
		
		bolnica.printInfoForDoctors();
		bolnica.printInfoForEmptyBeds();
		




		
		
		
	}

}
