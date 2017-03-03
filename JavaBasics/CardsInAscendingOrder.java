import java.util.Scanner;

public class CardsInAscendingOrder {
	//write a program that reads three chars separated by space - each one the strength 
	//of a card.Possible inputs are from 2..0 to T,J,K,Q,A.If the input is invalid the 
	//program must return the following"Invalid cards given!". The inputs are infinite. 
	//The program must stop when the cards are in ascending order.Finally, the program
	//must output the number of tries.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String threeCards = "";
		char card1,card2,card3;
		int countTries = 0;
		System.out.println("Please enter 3 cards separated by space:");
		do {
			threeCards = sc.nextLine();
			card1 = threeCards.charAt(0);
			card2 = threeCards.charAt(2);
			card3 = threeCards.charAt(4);
			countTries++;
			if(ascendingOrder(card1,card2,card3)) {
				break;
			}
			else {
				System.out.println("Invalid cards given!Try again.");
			}
		} while (!isValid(threeCards) || !validCard(card1) || !validCard(card2) || 
				!validCard(card3) || !ascendingOrder(card1,card2,card3));
	
		
		System.out.println("You have tried " + countTries + " times.");
			
	}
	static int value (char a) {
		int valueOfCard = 0;
		switch(a) {
		case '2':
			valueOfCard = 2;
			break;
		case '3':
			valueOfCard = 3;
			break;
		case '4':
			valueOfCard = 4;
			break;
		case '5':
			valueOfCard = 5;
			break;
		case '6':
			valueOfCard = 6;
			break;
		case '7':
			valueOfCard = 7;
			break;
		case '8':
			valueOfCard = 8;
			break;
		case '9':
			valueOfCard = 9;
			break;
		case 'T':
			valueOfCard = 10;
			break;
		case 'J':
			valueOfCard = 12;
			break;
		case 'Q':
			valueOfCard = 13;
			break;
		case 'K':
			valueOfCard = 14;
			break;
		case 'A':
			valueOfCard = 15;
			break;
		}
		return valueOfCard;
	}
	static boolean ascendingOrder (char a, char b, char c) {
		if (value(a)< value(b) && value(b) < value(c)) {
			return true;
		}
		return false;
	}
	static boolean validCard(char a) {
		if ( (a >= '2' && a <='9') || a == 'T' || a =='J' || a =='K' || a =='Q' || a =='A'){
			return true;
		}
		return false;
	}
	static boolean isValid(String a) {
		if(a.contains(" ")) {
			return true;
		}
		return false;
	}

}
