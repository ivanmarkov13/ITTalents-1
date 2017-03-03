
public class Page {
	
	private String title;
	private String text;
	private int pageNumber; // ����� �������� �� ��� �����
	
	
	
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
		return pageNumber; // �� �� ��������� ��� ������ reviewPages � ��������� �� notepades ��� ��������� ����������� �� ����������
	}

	public void setPageNumber(int pageNumber) {
		if (pageNumber>0) {
			this.pageNumber = pageNumber;
		}
	}

	public void addText(String t) {
	 this.text = this.text.concat(t); // ���� ����� ������� ������������ �� ������� ������ (�����) �� ������� �� ���� ��� ��� ������ - �������� �� ���������� �� ������� � ���������
	}
	
	public void deleteText() {
		this.text = "";
	}
	
	public String reviewPage() {
		if (!this.getText().isEmpty()) { //��� ���������� �� � ������ (�.�. ���� �����)
			return "        " + this.getTitle() + '\n' + this.getText(); // ����� ����������(����������) � ������ �� ��� ���
		}
		else { // � �������� ������ ����� ���������� � �����, �� ���� � ������ ��������
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
		if (this.text.contains(word)) { //��� ������� ������� ���������� ����, ����� ����
			return true;
		}
		else {
			return false;
		}
		
	}
	public boolean containsDigits() {
		for (int i = 0; i < this.text.length(); i++) { //����������� ���� ������ ������� ������ �� ��������� ���������
			if (text.charAt(i) >= '0' && text.charAt(i) <= '9') { // ��� �������, ������� ����
				return true;
			}
		}
		return false;
			
	}

}
