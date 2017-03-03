
public class Demo {
	public static void main(String[] args) {
		
	SecuredNotepad myNotepad = new SecuredNotepad("My notepad", 25, "1ahd29dkaK");
	
	myNotepad.addTextToPage("Днес е ужасен ден.Навън отново вали сняг. Искам да дойде пролетта вече." , 1);
	myNotepad.addTextToPage("Iskam da stana programist i shte dam vsichko ot sebe si.", 2);
	myNotepad.addTextToPage("Sentence with number 1", 3);
	myNotepad.reviewPages();
	myNotepad.overwriteTextOnPage("Вече е пролет и съм щастлива.", 1);
	myNotepad.reviewPages();

	
	myNotepad.searchWord("da");
	myNotepad.printAllPagesWithDigits();
	myNotepad.deleteTextFromPage(2);
	myNotepad.reviewPages();
	myNotepad.reviewParticularPage(1);
	
	ElectronicSecuredNotepad eNotepad = new ElectronicSecuredNotepad("notepad", 200, "7362hdA7");
	eNotepad.addTextToPage("jhsf", 2);
	eNotepad.start();
	eNotepad.addTextToPage("jhsf", 2);
	

	
	}

}
