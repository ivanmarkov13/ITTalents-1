
public class Page {
	
	private String title;
	private String text;
	private int pageNumber; // всяка страница си има номер
	
	
	
	public Page(String title, String text, int pageNumber) {
		if (title != null) {
			this.title = title;
		}
		else {
			this.title = "";
		}
		if (text != null) {
			this.text = text;
		} 
		else {
			this.text = "";
		}
		if (pageNumber > 0) {
			this.pageNumber = pageNumber;
		}
	}

	public int getPageNumber() {
		return pageNumber; // ще го използвам при метода reviewPages в класовете за notepades при изписване поредността на страниците
	}

	public void setPageNumber(int pageNumber) {
		if (pageNumber>0) {
			this.pageNumber = pageNumber;
		}
	}

	public void addText(String t) {
	 this.text = this.text.concat(t); // този метод променя референцията на текущия стринг (текст) да започне да сочи към нов стринг - резултат от слепването на текущия и подадения
	}
	
	public void deleteText() {
		this.text = "";
	}
	
	public String reviewPage() {
		if (!this.getText().isEmpty()) { //ако страницата не е празна (т.е. няма текст)
			return "        " + this.getTitle() + '\n' + this.getText(); // връща заглавието(центрирано) и текста на нов ред
		}
		else { // в противен случай връща заглавието и казва, че това е празна страница
				return "        " + this.getTitle() + '\n' + "This is a blank page";
			
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title != null ) {
			this.title = title;
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		if (text != null ) {
			this.text = text;
		}
	}
	
	public boolean searchWord(String word) {
		if (this.text.contains(word)) { //ако текстът съдържа подадената дума, връща труе
			return true;
		}
		else {
			return false;
		}
		
	}
	public boolean containsDigits() {
		for (int i = 0; i < this.text.length(); i++) { //проверяваме дали текста съдържа символ от числовото множество
			if (text.charAt(i) >= '0' && text.charAt(i) <= '9') { // ако съдържа, връщаме труе
				return true;
			}
		}
		return false;
			
	}

}
