
public class SimpleNotepad implements INotepad {

	private final String name;
	private Page [] pages;
	
	

	public SimpleNotepad(String name,int numberOfPages) {  
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
		else {
			this.name = "Notepad";
		}
		if (numberOfPages > 0) { //������ ���������� ������, ������ �� ����� � ����� �������� �� �������, ������ ��� �� ������ �� ������� ��������, ���� ��� �� �����.
			pages = new Page [numberOfPages]; //������ �������� � ������������ �� �� ������� ���� �������� � ����� ������������� �������� � ������� ������ ��������
		}
		else {
			pages = new Page[100];
		}
		int currentPageNumber=1;
			for (int i = 0; i < pages.length; i++) {
			pages[i] = new BlankPage(currentPageNumber++); //�������� ������ ��������, ���� ���������� ������ �� ���������� ����� ���
		}
	}
	
	//��������� ������ �� ��������� pageNumber, ����� �� ������ ���� ��������� �� �������� � ��������� �� 1 �� ��������� �� ������ 
	// ��� ��������, ������ ���� ���������� ������ � ������ �� ����������(� ������� �� 1), � �� ������� �� �������� �������� � ������
		

	@Override
	public void addTextToPage(String text, int pageNumber) {
		if (text != null && !text.isEmpty() && pageNumber > 0 && pageNumber <= pages.length) { //� ���������� ����� �� � ���� � �� � ������, ����� � ������ �� ���������� � �� 1 �� ��������� �� ������
			pages[pageNumber-1].addText(text); // �������� ����� �� ����������� �������� (pageNumber-1,������ � ������ �������� �� 0, � ����������� �� ���������� �� 1) ��������� ������ addText
		}
	}

	@Override
	public void overwriteTextOnPage(String text, int pageNumber) {
		if (text != null && !text.isEmpty() && pageNumber > 0 && pageNumber <= pages.length) { 
			pages[pageNumber-1].deleteText();// ��� �� ��������� ���������, ����� �� ���� ������ �� ��������� �� ������
			pages[pageNumber-1].addText(text); // � ����� �� ������ ����� �����
		}
		
	}

	@Override
	public void deleteTextFromPage(int pageNumber) {
		if (pageNumber > 0 && pageNumber <= pages.length) {
			pages[pageNumber-1].deleteText(); 
		}
	}

	@Override
	public void reviewPages() {
		for (int i = 0; i < pages.length; i++) {
				System.out.println("page �" + pages[i].getPageNumber() + " " + pages[i].reviewPage()); //���������� ������ �� ���������� � ������������(�������� � �����) �� ��� 
		}
		
	}
	
	@Override
	public boolean searchWord(String word) {
		boolean contains = false; // ������ ����������, ����� �� ����� ���� ����� �� ���������� ������� ������
		for (int i = 0; i < pages.length; i++) { //������ ������ ��� ����� ���� ��������
			if (pages[i].searchWord(word)) {
				contains = true; //��� � ���, ������������ �� ����� ������
				break; //������ �� ��������, ������ ������ ���� ������ ����� �� ���������� ������� ������
			}
		}
		if (contains) { //���� ������ ����������� ���� � ����� � ������ ���� ������� ����� ���� ��� ����
			System.out.println("The notepad contains the word " + word + ".");
			return true;
		}
		else {
			System.out.println("The notepad does not contain the word " + word + ".");
			return false;
		}
	}

	@Override
	public void printAllPagesWithDigits() {
		for (int i = 0; i < pages.length; i++) {
			if (pages[i].containsDigits()) {  //��� ���������� ������� �����, � ���������� �� ������
				System.out.println("Page that contains digits: ");
				System.out.println("page �" + pages[i].getPageNumber() + pages[i].reviewPage());
			}
		}
	}

	@Override
	public void reviewParticularPage(int pageNumber) { // �������� �� ������������ �����, ����� �� ������� ��������� �������� �� ��������
		// TODO Auto-generated method stub
		if(pageNumber > 0  && pageNumber <= pages.length) {
			System.out.println("page �" + pages[pageNumber-1].getPageNumber() + " " + pages[pageNumber-1].reviewPage());  
		}
		
	}
	

}
