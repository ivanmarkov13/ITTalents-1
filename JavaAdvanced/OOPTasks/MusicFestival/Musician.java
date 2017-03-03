package MusicFestival;

public abstract class Musician {
	
	private String name;
	private boolean isAvocalist;
	
	

	public Musician(String name,boolean isAvocalist) {
		if(name != null && !name.isEmpty()) {
			this.name = name;
		}
		else {
			this.name = "Musician";
		}
		this.isAvocalist = isAvocalist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getInfo () {
		return null;
	}

}
