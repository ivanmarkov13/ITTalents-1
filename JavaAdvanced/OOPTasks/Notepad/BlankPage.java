
public class BlankPage extends Page {
	//създавам си такъв клас, който да наследява класа Page,защото всеки ноутпад се създава с празни страници 
	//следователно трябва да имаме такъв обект

	public BlankPage(int pageNumber) {
		super("New Page", "", pageNumber); // всяка празна страница ще се създава със заглавие "New page" и ще е празна
		
	}
	

}
