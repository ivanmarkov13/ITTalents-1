
public interface INotepad {
	
	public void addTextToPage(String text, int pageNumber);
	
	public void overwriteTextOnPage (String text, int pageNumber);
	
	public void deleteTextFromPage(int pageNumber);
	
	public void reviewPages();
	
	public boolean searchWord(String word);
	
	public void printAllPagesWithDigits();
	
	public void reviewParticularPage(int pageNumber);

}
