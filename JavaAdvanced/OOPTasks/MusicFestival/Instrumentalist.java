package MusicFestival;

public class Instrumentalist extends Musician{
	
	private String instrument;
	
	Instrumentalist (String name,boolean isAvocalist, String instrument) {
		super(name,isAvocalist);
		if (instrument != null && !instrument.isEmpty()) {
			this.instrument = instrument;
		}
	}
	
	public String getInfo () {
		return super.getName() + " - " + this.instrument;
	}
	
	

}
