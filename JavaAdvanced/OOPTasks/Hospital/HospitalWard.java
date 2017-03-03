package hospital;

import java.util.ArrayList;
import hospital.Hospital.WardName;
import hospital.Patient.Gender;

public abstract class HospitalWard {
	
	private ArrayList<Room> rooms;
	private WardName name;
	
	public HospitalWard(WardName name) {
		rooms = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if (i%2==0) {
				rooms.add(new Room(Gender.FEMALE));
			} else {
				rooms.add(new Room(Gender.MALE));
			}
		}
		this.name = name;
	}
	
	public WardName getName() {
		return name;
	}
	
	public ArrayList<Room> getRooms() {
		return rooms;
	}

}
