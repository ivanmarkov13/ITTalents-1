package hospital;

import java.util.ArrayList;

import hospital.Patient.Gender;

public class Room {
	
	private ArrayList<Bed> beds;
	private Gender roomType; // room type of type Gender cause in one room can be only people from the same gender 
	
	public Room(Gender roomType) {	
		this.beds = new ArrayList<>();
		beds.add(new Bed());
		beds.add(new Bed());
		beds.add(new Bed());
		this.roomType = roomType;
	}
	
	public ArrayList<Bed> getBeds() {
		return beds;
	}
	
	public Gender getRoomType() {
		return roomType;
	}
	

}
