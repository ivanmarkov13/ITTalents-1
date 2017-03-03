import java.util.Scanner;

public class SecuredNotepad extends SimpleNotepad implements ISecuredNotepad {
	
	private String password;
	Scanner sc = new Scanner(System.in);
	

	public SecuredNotepad(String name,int numberOfPages, String password) {  
		super(name, numberOfPages);
		if (password != null && validatePassword(password)) {
			this.password = password;
		}
		else {
			throw new IllegalArgumentException( //�� ���� ����� ����������� �� �� ������� ����� �� ���� ����
					"The password is not strong enough!");
		}
	}
	
	@Override
	public void addTextToPage(String text, int pageNumber) {
		for (int i = 0; i < 3; i++) { //���� ����� �� �� ����� 3 ���� � �� ������� ���� ������, ��� �� � �������� �������� ������
			if (correctPassword()) { //��� �������� � ��������
				super.addTextToPage(text, pageNumber); //������ ����� ������ 
				break; //��� ��� ������ � ��� �� �������� ������, ��� ��������� 
			} //��� �� ���, ������� �� �� ������� ������ (3 ����)
		}
	}

	@Override
	public void overwriteTextOnPage(String text, int pageNumber) { 
		for (int i = 0; i < 3; i++) { // ���������� �� �������� - ���������� � ������ ����� 
			if (correctPassword()) {
				super.overwriteTextOnPage(text, pageNumber);
				break;
			}
		}
	}

	@Override
	public void deleteTextFromPage(int pageNumber) {
		for (int i = 0; i < 3; i++) {
			if (correctPassword()) {
				super.deleteTextFromPage(pageNumber);
				break;
			}
		}
	}

	@Override
	public void reviewPages() {
		for (int i = 0; i < 3; i++) {
			if (correctPassword()) {
				super.reviewPages();
				break;
			}
		}
	}

	@Override
	public boolean searchWord(String word) {
		for (int i = 0; i < 3; i++) {
			if (correctPassword()) {
				super.searchWord(word);
			}		
		}
		return false; // ��� ���� ������, ������� �� � ������ ��������, ��������, �� �������� � �������� ������ �� 3 ����.. �.�. �� � ��������� �� ������� ���� �������� �� ������� ������, ������ �������, �� �� �� �������
	}

	@Override
	public void printAllPagesWithDigits() {
		for (int i = 0; i < 3; i++) {
			if(correctPassword()) {
				super.printAllPagesWithDigits();
				break; // ��� �������� ����� ������, ���� ���� �� ������ �� �������� �� ���������� (��� �������� ���� � ����� �������� � ����� ��� ��), ������ �� �������� ������ �� ��������� �� ��������
			} 
			
		}
	}
	public boolean correctPassword() { // ���� � �����, ����� �� ��������� ���� �������� � ��������
		System.out.println("Please enter your password:");
		String password = sc.nextLine();
		if (password.equals(this.password)) {
			System.out.println("The password is correct!");
			return true;
		}
		System.out.println("The password is incorrect!");
		return false;
	}

	@Override
	public void reviewParticularPage(int pageNumber) { // �������� �� ������������ �����, ����� �� ������� ������ ��������
		for (int i = 0; i < 3; i++) {
			if(correctPassword()) {
				super.reviewParticularPage(pageNumber);
				break;
			}
		}
		
	}
	
	/* �� �� ������� ���������������� �� 
			SecuredNotepad, ���� �� ����� ������� �������� �� ������� �������� �� ����� ������ ��� 
			����������� ��. ��� ����� ������ �� ������� ������ � ���� 5 �������, � ���� ���� ����� �����, ������ ����� � ����� (�� �� 
			������ ������ charAt �� ����� String.
	*/
	public boolean validatePassword (String password) {
		boolean upperCaseLetter = false; // �������� 3 ������ ����������, ����� �� ������ ���� ��� ����� �� ������������
		boolean lowerCaseLetter = false;
		boolean digit = false;
		if(password.length() < 5 || password.length() > 20) { 
			return false;
		}
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') { // ����������� ���� ��� ������ �����
				upperCaseLetter = true;
				continue;
			}
			if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z' ) { // ����������� ���� ��� ����� �����
				lowerCaseLetter = true;
				continue;
			}
			if (password.charAt(i) >= '0' && password.charAt(i) <= '9'){ // ����������� �� �����
				digit = true;
				continue;
			}
			if (upperCaseLetter && lowerCaseLetter && digit) { // ��� ��� ��������� � ����� ����������, ���� ������ �� ������������ ������ � �� ���������
				break;
			}
		}
		if (upperCaseLetter && lowerCaseLetter && digit) {
			return true;
		}
		else {
			return false;
		}
	}
}
