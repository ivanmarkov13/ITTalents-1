import java.util.Scanner;

public class TwoStrongCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String card1,card2;
		int strongCombination=0;
		Scanner sc = new Scanner(System.in);
		int countTries=0;
		
		do {
			System.out.println("Enter two cards (digit for number or J,D,K or A");
			card1 = sc.nextLine();
			card2 = sc.nextLine();
			countTries++;
			if ((card1.equals("A") && (card2.equals("10") || card2.equals("J") || card2.equals("D") || card2.equals("K")|| card2.equals("A"))) || 
					(card2.equals("A") && (card1.equals("10") || card1.equals("J") || card1.equals("D") || card1.equals("K")|| card1.equals("A")))) {
				strongCombination++;
			}
			else {
				strongCombination = 0;
			}
			if(!isValid(card1) || !isValid(card2)) {
				strongCombination=0;
			}
		} while (strongCombination<5);
		
		System.out.println("The number of tries is " + countTries + ".");
		
	}
	static boolean isValid (String x) {
		if (x.equals("2") || x.equals("3") || x.equals("4") || x.equals("5") || x.equals("6") || x.equals("7") || x.equals("8") || 
			x.equals("9") || x.equals("10") || x.equals("J") || x.equals("D") || x.equals("K") || x.equals("A")) { 
			return true;
		}
		return false;
	}

}
