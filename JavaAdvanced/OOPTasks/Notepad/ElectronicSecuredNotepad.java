
public class ElectronicSecuredNotepad extends SecuredNotepad implements IElectronicDevice {
	
	private boolean isStarted;

	public ElectronicSecuredNotepad(String name, int numberOfPages, String password) {
		super(name, numberOfPages, password);
	}

	@Override
	public void start() {
		isStarted = true;
		
	}

	@Override
	public void addTextToPage(String text, int pageNumber) {
		if(this.isStarted) {
			super.addTextToPage(text, pageNumber);
		}
		else {
			System.out.println("Turn me on!");
		}
	}

	@Override
	public void overwriteTextOnPage(String text, int pageNumber) {
		if(this.isStarted) {		
			super.overwriteTextOnPage(text, pageNumber);
		}
		else {
			System.out.println("Turn me on!");
		}
	}

	@Override
	public void deleteTextFromPage(int pageNumber) {
		if(this.isStarted) {		
			super.deleteTextFromPage(pageNumber);
		}
		else {
			System.out.println("Turn me on!");
		}
	}
	
	@Override
	public void reviewPages() {
		if(this.isStarted) {		
			super.reviewPages();
		}
	
		else {
			System.out.println("Turn me on!");
		}
	}

	@Override
	public boolean searchWord(String word) {
		if(this.isStarted) {	
			return super.searchWord(word);
		}
		else {
			System.out.println("Turn me on!");
			return false;
		}
	}

	@Override
	public void printAllPagesWithDigits() {
		if(this.isStarted) {		
			super.printAllPagesWithDigits();
		}
		else {
			System.out.println("Turn me on!");
		}
	}

	@Override
	public void reviewParticularPage(int pageNumber) {
		if(this.isStarted) {			
			super.reviewParticularPage(pageNumber);
		}
		else {
			System.out.println("Turn me on!");
		}
	}

	@Override
	public void stop() {
		isStarted=false;
	}
}
