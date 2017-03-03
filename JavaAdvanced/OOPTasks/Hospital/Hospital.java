package hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.text.Position;

import java.util.Map.Entry;
import hospital.Doctor.Diagnosis;
import hospital.Doctor.Medicine;

public class Hospital {
	public enum position { DOCTOR, NURSE}
	public enum WardName { ORTHOPEDY, CARDIOLOGY, VIROLOGY}

	private HashMap<position, ArrayList<MedicalPerson>> staff;
	private ArrayList<MedicalRecord> medicalRecords;
	private HashMap<WardName, HospitalWard> hospitalWards;
	
	
	//create a hospital with doctors and nurses
	public Hospital() {
		hospitalWards = new HashMap<>();
		hospitalWards.put(WardName.CARDIOLOGY, new Cardiology());
		hospitalWards.put(WardName.ORTHOPEDY, new Orthopedy());
		hospitalWards.put(WardName.VIROLOGY, new Virology());
		staff = new HashMap<>();
		staff.put(position.DOCTOR, new ArrayList<>());
		staff.put(position.NURSE, new ArrayList<>());
		staff.get(position.DOCTOR).add(new Doctor("Doctor 1", "0846263723", "Cardiologist",hospitalWards.get(WardName.CARDIOLOGY)));
		staff.get(position.DOCTOR).add(new Doctor("Doctor 2", "0887535274", "Orthopedist", hospitalWards.get(WardName.ORTHOPEDY)));
		staff.get(position.DOCTOR).add(new Doctor("Doctor 3", "0887588065", "Virologist", hospitalWards.get(WardName.VIROLOGY)));
		staff.get(position.DOCTOR).add(new Doctor("Doctor 4", "0985274943", "Cardiologist",hospitalWards.get(WardName.CARDIOLOGY)));
		staff.get(position.DOCTOR).add(new Doctor("Doctor 5", "0997526472", "Orthopedist",hospitalWards.get(WardName.ORTHOPEDY)));
		staff.get(position.DOCTOR).add(new Doctor("Doctor 6", "0896526211", "Virologist", hospitalWards.get(WardName.VIROLOGY)));
		staff.get(position.NURSE).add(new Nurse("Nurse 1", "0886342643", 26, 4, hospitalWards.get(WardName.CARDIOLOGY)));
		staff.get(position.NURSE).add(new Nurse("Nurse 2", "0885352434", 29, 9, hospitalWards.get(WardName.ORTHOPEDY)));
		staff.get(position.NURSE).add(new Nurse("Nurse 3", "0862727763", 23, 2, hospitalWards.get(WardName.ORTHOPEDY)));
		staff.get(position.NURSE).add(new Nurse("Nurse 4", "0886342643", 35, 13, hospitalWards.get(WardName.CARDIOLOGY)));
		staff.get(position.NURSE).add(new Nurse("Nurse 5", "0886342643", 37, 14, hospitalWards.get(WardName.VIROLOGY)));
		staff.get(position.NURSE).add(new Nurse("Nurse 6", "0896342143", 28, 6, hospitalWards.get(WardName.VIROLOGY)));
		medicalRecords = new ArrayList<>();
	}
	
	
	public void hospitalize(Patient p) {
		//create a new medical record - put in in the hospital records and set it as a patient's record
		MedicalRecord newMedicalRecord = new MedicalRecord(p.getName(), p.getAge(), p.getPhoneNumber());
		p.setMedicalRecord(newMedicalRecord);
		medicalRecords.add(newMedicalRecord);
		//check if there are available doctors
		Doctor doc = (Doctor)staff.get(position.DOCTOR).get(0);
		boolean assingDoctor=false;
		for (Entry<position, ArrayList<MedicalPerson>> e : staff.entrySet()) {
			if (e.getKey()==position.DOCTOR) {
				for (MedicalPerson doctor : e.getValue()) {
					Doctor n = (Doctor) doctor;
					if (!n.getIsbusy()) {
						assingDoctor = true;
						doc = n;
						break;
					}
				}
				break;
			}
		} //if there is available doctor set it as patient's doctor 
		if(assingDoctor) {	
			p.setDoctor(doc);
			doc.setBusy(true);
			doc.addPatient(p);
			//make a plan for treatment
			p.setPlanForTreatment(doc.planForTreatment());
			//set the diagnosis (from the plan treatment)
			for (Entry<Diagnosis, Medicine> entry : p.getPlanForTreatment().entrySet()) {
				p.setDiagnosis(entry.getKey());
			}
			//set hospitalWard
			p.setHospitalWard(p.getDiagnosis().getWard());
			p.printInfoForPatient();
			//place patient in room
			placePatientInRoom(p);
		}
		else {
			System.out.println("No available doctors right now. The patient should wait!");
		}
	}
	
	private void placePatientInRoom(Patient p) {
		//check for available rooms
		ArrayList<Room> rooms = hospitalWards.get(p.getHospitalWard()).getRooms();
		boolean placedInRoom = false;
		for (int i = 0; i < rooms.size(); i++) {
			ArrayList<Bed> beds = rooms.get(i).getBeds();
			if (rooms.get(i).getRoomType()==p.getGender()) {
				for (int j = 0; j < beds.size(); j++) {
					if (beds.get(j).getIsEmpty()) {
						beds.get(j).setEmpty(false);
						p.setRoomNumber(i);
						p.setBedNumber(j);
						placedInRoom=true;
						break;
					}	
				}
			}
			if (placedInRoom) {
				break;
			}
			
		}
		if(!placedInRoom) {
			System.out.println("No empty beds right now.");
		}
	}
	
	public void startTreatment (Patient p) {
		//a nurse from the same ward gives medicine to the patient and then the doctor visits the patient
		for (Entry<position, ArrayList<MedicalPerson>> entry : staff.entrySet()) {
			if (entry.getKey()==position.NURSE) {
				for ( MedicalPerson nurse : entry.getValue()) {
					Nurse n = (Nurse) nurse;
					//find a nurse from the same ward
					if (n.getHospitalWard().getName()==p.getHospitalWard()) { 
						n.takeCare(p);
						break;
					}
				}
				break;
			}
		}
		p.getDoctor().visitPatient(p);
	}
	
	
	public void dischargePatient (Patient p) {
		//make the doctor available, remove the patient from doctor patients and empty the bed
		p.getDoctor().setBusy(false);
		p.getDoctor().getPatients().remove(p);
		hospitalWards.get(p.getHospitalWard()).getRooms().get(p.getRoomNumber()).getBeds().get(p.getBedNumber()).setEmpty(true);
		System.out.println("Patient " + p.getName() + " from gender " + p.getGender() + " with diagnosis " + p.getDiagnosis() + " has been discharged!");
	}
	
	
	public void printInfoForEmptyBeds() {
		//count the empty beds in each ward
		for (Entry<WardName, HospitalWard> entry : hospitalWards.entrySet()) {
			System.out.println("==========" + entry.getKey() + "==========");
			int emptyBeds = 0;
			for (Room room : entry.getValue().getRooms()) {
				for (Bed bed : room.getBeds()) {
					if(bed.getIsEmpty()) {
						emptyBeds++;
					}
				}
				
			}
			System.out.println("Empty beds - " + emptyBeds);
		}
		
	}
	
	public void printInfoForDoctors() {
		//print the patients for each doctor
		for (Entry<position, ArrayList<MedicalPerson>> entry : staff.entrySet()) {
			if (entry.getKey()==position.DOCTOR) {
				for (MedicalPerson person : entry.getValue()) {
					Doctor d = (Doctor) person;
					System.out.println(d.name + " - " + d.getSpecialization());
					d.printPatients();
				}
				
			}
			
		}
	}
	
}
