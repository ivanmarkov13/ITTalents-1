package MusicFestival;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MusicFestival x = new MusicFestival("New Festival", 2, "20.07.2017, 20:00", "Downtown");
		Band band1 = new Band("Band1", 3, 2,true);
		Band band2 = new Band("Band2", 2, 5, false);
		Act act = new Act(band1, "20:00", "21:00");
		Act act2 = new Act(band2, "21:00", "22:00");
		x.getActs()[0] = act;
	
		
		
		Musician pesho = new Vocalist ("Petur", true);
		Musician ivan = new Instrumentalist("Ivan",false, "quitar");
		
		band1.getMusicians()[0] = pesho;
		band1.getMusicians()[1] = ivan;
		band1.getSongs()[0] = new Song("Song 1", "Song text...");
		band1.getSongs()[1] = new Song("Song 2", "Song text...");
		band1.getSongs()[2] = new Song("Song 3", "Song text...");
		
		x.printInfoForTheFestival();
		x.pritnGeneralInfo();

	}

}
