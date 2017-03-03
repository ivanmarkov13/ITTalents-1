package MusicFestival;

public class Act {
	private Band band;
	private String start;
	private String end;
	
		public Act(Band band, String start, String end) {
		super();
		this.band = band;
		this.start = start;
		this.end = end;
	}
	
	public Band getBand() {
		return band;
	}
	public void setBand(Band band) {
		this.band = band;
	}
	public String getStart() {
		return this.start;
	}
	public String getEnd() {
		// TODO Auto-generated method stub
		return this.end;
	}
	
	public void printInfoForBand () {
		System.out.println(this.band.getName() + ", Starts at: " + this.start+ ", Ends at: " + this.end);
	}


}
