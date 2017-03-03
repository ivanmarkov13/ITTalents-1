package hospital;

import java.util.HashMap;

import hospital.Doctor.Diagnosis;
import hospital.Doctor.Medicine;
import hospital.Hospital.WardName;

public class Patient {

	public enum Gender {FEMALE, MALE}
	
	private String name;
	private int age;
	private String phoneNumber;
	private Gender gender;
	private MedicalRecord medicalRecord;
	private Doctor doctor;
	private Diagnosis diagnosis;
	private WardName hospitalWard;
	private int roomNumber;
	private int bedNumber;
	private HashMap<Diagnosis, Medicine> planForTreatment;
	
	public Patient(String name, Gender gender, int age, String number) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phoneNumber = number;
	}
	
	public String getName() {
		return name;
	}
	public Gender getGender() {
		return gender;
	}
	
	public int getAge() {
		return age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}
	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	
	public WardName getHospitalWard() {
		return this.hospitalWard;
	}
	public void setHospitalWard(WardName hospitalWard) {
		this.hospitalWard = hospitalWard;
	}
	public Diagnosis getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	public HashMap<Diagnosis, Medicine> getPlanForTreatment() {
		return planForTreatment;
	}

	public void setPlanForTreatment(HashMap<Diagnosis, Medicine> planForTreatment) {
		this.planForTreatment = planForTreatment;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getBedNumber() {
		return bedNumber;
	}
	public void setBedNumber(int bedNumber) {
		this.bedNumber = bedNumber;
	}

	
	public void printInfoForPatient () {
		System.out.println("Patient " + this.getName() + " from gender " + this.getGender() + 
				" hospitalized with diagnosis " + this.getDiagnosis() + ". Doctor " + this.getDoctor().getName());
	}
	
	
	
	
	
}
