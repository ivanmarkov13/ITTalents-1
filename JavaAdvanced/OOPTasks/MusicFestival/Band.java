package MusicFestival;

public class Band {
	private String name;
	private Song[] songs;
	private Musician[] musicians;
	private boolean hasAvocalist;
	
	
	public Band(String name, int numberOfSongs, int numberOfmusicians,boolean hasAvocalist) {
		this.name = name;
		this.songs = new Song[numberOfSongs];
		this.musicians = new Musician[numberOfmusicians];
		this.hasAvocalist=hasAvocalist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Song[] getSongs() {
		return songs;
	}
	public void setSongs(Song[] songs) {
		this.songs = songs;
	}
	public Musician[] getMusicians() {
		return musicians;
	}
	public void setMusicians(Musician[] musicians) {
		this.musicians = musicians;
	}
	
	public boolean hasAVocalist () {
		for (int i = 0; i < musicians.length; i++) {
			if (musicians[i] instanceof Vocalist) {
				return true;
			}
		}
		return false;
	}
	
	public void printInforSongs () {
		for (int i = 0; i < musicians.length; i++) {
			System.out.println(musicians[i].getInfo());
		}
		if (this.hasAVocalist()) {
			for (int k = 0; k < this.songs.length; k++) {
			System.out.println("          " + this.songs[k].getTitle());
			System.out.println(this.songs[k].getText());
			}
		}
	}
	

}
