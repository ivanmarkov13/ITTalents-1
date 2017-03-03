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
			throw new IllegalArgumentException( //по този начин забраняваме да се създава обект от този клас
					"The password is not strong enough!");
		}
	}
	
	@Override
	public void addTextToPage(String text, int pageNumber) {
		for (int i = 0; i < 3; i++) { //този цикъл ще се върти 3 пъти и ще изисква нова парола, ако не е въведена правилна парола
			if (correctPassword()) { //ако паролата е правилна
				super.addTextToPage(text, pageNumber); //викаме супер метода 
				break; //ако сме влезли в ифа за правилна парола, тук брейкваме 
			} //ако не сме, цикълът ще се завърти отново (3 пъти)
		}
	}

	@Override
	public void overwriteTextOnPage(String text, int pageNumber) { 
		for (int i = 0; i < 3; i++) { // валидиране на паролата - аналогично с горния метод 
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
		return false; // ако след цикъла, методът не е върнал резултат, означава, че паролата е сгрешена повече от 3 пъти.. т.е. не е безопасно да връщаме дали наистина се съдържа думата, затова връщаме, че не се съдържа
	}

	@Override
	public void printAllPagesWithDigits() {
		for (int i = 0; i < 3; i++) {
			if(correctPassword()) {
				super.printAllPagesWithDigits();
				break; // при въведена вярна парола, след края на цикъла за проверка на страниците (без значение дали е имало страница с цифри или не), трябва да брейкнем цикъла за валидация на паролата
			} 
			
		}
	}
	public boolean correctPassword() { // това е метод, който ще провеярва дали паролата е правилна
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
	public void reviewParticularPage(int pageNumber) { // създадох си допълнителен метод, който да показва дадена страница
		for (int i = 0; i < 3; i++) {
			if(correctPassword()) {
				super.reviewParticularPage(pageNumber);
				break;
			}
		}
		
	}
	
	/* Да се промени функционалността на 
			SecuredNotepad, така че всеки защитен бележник да изисква задаване на силна парола при 
			създаването си. Под силна парола се разбира парола с поне 5 символа, с поне една малка буква, голяма буква и число (Ще ви 
			трябва метода charAt на класа String.
	*/
	public boolean validatePassword (String password) {
		boolean upperCaseLetter = false; // създавам 3 булеви променливи, които ще следят дали има всяко от изискванията
		boolean lowerCaseLetter = false;
		boolean digit = false;
		if(password.length() < 5 || password.length() > 20) { 
			return false;
		}
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') { // проверяваме дали има голяма буква
				upperCaseLetter = true;
				continue;
			}
			if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z' ) { // проверяваме дали има малка буква
				lowerCaseLetter = true;
				continue;
			}
			if (password.charAt(i) >= '0' && password.charAt(i) <= '9'){ // проверяваме за цифра
				digit = true;
				continue;
			}
			if (upperCaseLetter && lowerCaseLetter && digit) { // ако сме изпълнили и трите изисквания, няма смисъл да продължаваме цикъла и го брейкваме
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
