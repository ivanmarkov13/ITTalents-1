package MusicFestival;

public class Vocalist extends Musician {
	
	public Vocalist (String name,boolean isAvocalist) {
		super(name,isAvocalist);
	}
	
	public String getInfo () {
		return "Vocalist: " + super.getName();
	}

}
