
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
		if (numberOfPages > 0) { //понеже използваме масиви, трябва да знаем с колко страници ще работим, защото ако се наложи да добавим страница, няма как да стане.
			pages = new Page [numberOfPages]; //затова изисквам в конструктура да се подадат брой страници и после инициализирам ноутпада с толкова празни страници
		}
		else {
			pages = new Page[100];
		}
		int currentPageNumber=1;
			for (int i = 0; i < pages.length; i++) {
			pages[i] = new BlankPage(currentPageNumber++); //създавам празни страници, като увеличавам номера на страницата всеки път
		}
	}
	
	//навсякъде надолу ще валидирам pageNumber, която се подава като параметър на методите в интервала от 1 до дължината на масива 
	// със страници, защото тази променлива реално е номера на страницата(и започва от 1), а не индекса на елемента страница в масива
		

	@Override
	public void addTextToPage(String text, int pageNumber) {
		if (text != null && !text.isEmpty() && pageNumber > 0 && pageNumber <= pages.length) { //и подаденият текст не е нулл и не е празен, както и номера на страницата е от 1 до дължината на масива
			pages[pageNumber-1].addText(text); // добавяме текст на съответната страница (pageNumber-1,защото в масива започват от 0, а номерацията на страниците от 1) извикваме метода addText
		}
	}

	@Override
	public void overwriteTextOnPage(String text, int pageNumber) {
		if (text != null && !text.isEmpty() && pageNumber > 0 && pageNumber <= pages.length) { 
			pages[pageNumber-1].deleteText();// ако са изпълнени условията, първо се вика метода за изтриване на текста
			pages[pageNumber-1].addText(text); // и после се добавя новия текст
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
				System.out.println("page №" + pages[i].getPageNumber() + " " + pages[i].reviewPage()); //принтираме номера на страницата и информацията(заглавие и текст) за нея 
		}
		
	}
	
	@Override
	public boolean searchWord(String word) {
		boolean contains = false; // булева променлива, която да следи дали някоя от страниците съдържа думата
		for (int i = 0; i < pages.length; i++) { //търсим думата във всяка една страница
			if (pages[i].searchWord(word)) {
				contains = true; //ако я има, променливата ни става истина
				break; //трябва да брейкнем, защото търсим дали просто някоя от страниците съдържа думата
			}
		}
		if (contains) { //след цикъла проверяваме дали е вярно и според това методът връща труе или фолс
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
			if (pages[i].containsDigits()) {  //ако страницата съдържа цифри, я принтираме на екрана
				System.out.println("Page that contains digits: ");
				System.out.println("page №" + pages[i].getPageNumber() + pages[i].reviewPage());
			}
		}
	}

	@Override
	public void reviewParticularPage(int pageNumber) { // създадох си допълнителен метод, който да показва конкретна страница от ноутпада
		// TODO Auto-generated method stub
		if(pageNumber > 0  && pageNumber <= pages.length) {
			System.out.println("page №" + pages[pageNumber-1].getPageNumber() + " " + pages[pageNumber-1].reviewPage());  
		}
		
	}
	

}
