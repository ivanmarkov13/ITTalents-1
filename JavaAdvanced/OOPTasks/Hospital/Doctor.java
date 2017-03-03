package hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import hospital.Hospital.WardName;

public class Doctor extends MedicalPerson {

	//diagnosis with relevant medicine and hospital ward
	public enum Diagnosis { HEART_ATTACK(Medicine.BETALOK,WardName.CARDIOLOGY), STROKE(Medicine.LEVZEYA,WardName.CARDIOLOGY), COLD(Medicine.IMUNOBOR,WardName.VIROLOGY), FLU(Medicine.PARACETAMAX,WardName.VIROLOGY), BROKEN_LEG(Medicine.VITAMIN_C,WardName.ORTHOPEDY), BROKEN_ARM(Medicine.BENALGIN,WardName.ORTHOPEDY);
		 private Medicine medicine;
		 private WardName ward;
		 private Diagnosis(Medicine medicine, WardName hospitalWard) {
			 this.medicine = medicine;
			 this.ward = hospitalWard;
		}
		 public Medicine getMedicine() {
			return medicine;
		}
		 public WardName getWard() {
			return ward;
		}
	}
	
	public enum Medicine { VITAMIN_C, PARACETAMAX, BENALGIN, LEVZEYA, IMUNOBOR, BETALOK}

	private String specialization;
	private ArrayList<Patient> patients;
	private boolean isbusy;
	
	public Doctor(String name, String phoneNumber,String specialization, HospitalWard hospitalWadrd) {
		super(name, phoneNumber,hospitalWadrd);
		this.specialization = specialization;
		this.patients = new ArrayList<>();
		this.isbusy=false;
	}
	
	public String getSpecialization() {
		return specialization;
	}
	
	public boolean getIsbusy() {
		return isbusy;
	}

	public void setBusy(boolean isbusy) {
		this.isbusy = isbusy;
	}

	//the method returns the diagnosis with the relevant medicine 
	public HashMap<Diagnosis, Medicine> planForTreatment () {
		//put all diagnosis in one list
		ArrayList<Diagnosis> diagnosis = new ArrayList<>();
		//check what is the doctor's specialization in order to set an adequate diagnosis
		if (this.hospitalWard.getName() == WardName.CARDIOLOGY) {
			diagnosis.add(Diagnosis.STROKE);
			diagnosis.add(Diagnosis.HEART_ATTACK);
		} else {
			if(this.hospitalWard.getName()==WardName.ORTHOPEDY) {
				diagnosis.add(Diagnosis.BROKEN_ARM);
				diagnosis.add(Diagnosis.BROKEN_LEG);
			}
			else {
				diagnosis.add(Diagnosis.COLD);
				diagnosis.add(Diagnosis.FLU);
			}
		}
		//get a random diagnosis
		int r = new Random().nextInt(diagnosis.size());
		HashMap<Diagnosis, Medicine> planForTreatment = new HashMap<>();
		planForTreatment.put(diagnosis.get(r), diagnosis.get(r).getMedicine());
		return planForTreatment;
		
	}

	public String getName() {
		return this.name;
	}
	
	public void visitPatient(Patient p) {
		System.out.println("Doctor " + this.name + " visited patient "  + p.getName() + " in room "
				+ p.getRoomNumber() + " in ward " + p.getHospitalWard());
	}
	
	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public void addPatient(Patient p) {
		this.patients.add(p);
	}
	
	public void printPatients() {
		for (Patient patient : patients) {
			patient.printInfoForPatient();
		}
	}
	
	
}
