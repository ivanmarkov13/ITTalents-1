import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter some text:");
		String text = sc.nextLine();
		text = text.toUpperCase();
		sc.close();
		
		HashMap<Character, Integer> mostCommonLetters = new HashMap<>();
		
	
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (Character.isAlphabetic(c) ) {
			  if (mostCommonLetters.containsKey(c)) {
			    int counter = mostCommonLetters.get(c);
			    mostCommonLetters.put(c, ++counter);
			  } else {
			    mostCommonLetters.put(c, 1);
			  }
			}
		}
		printResult(sortByValue(mostCommonLetters));
	}
		static double getMaxOccurence(HashMap<Character, Integer> hashMap) {
			double max = 0;
			for (Entry<Character, Integer> temp : hashMap.entrySet()) {
				if((int)temp.getValue()>max) {
					max = (int)temp.getValue();
				}
			}
			return max;
	}
		
		static void printResult(HashMap<Character,Integer> hashMap) {
			for (Entry<Character, Integer> temp : hashMap.entrySet()) {
				System.out.print(temp.getKey() + " : " + temp.getValue() + " ");
				double counter = ((int)temp.getValue()==getMaxOccurence(hashMap)?20:(int)temp.getValue()/getMaxOccurence(hashMap)*20);
				for (int i = 0; i < counter; i++) {
					System.out.print("#");
					
				}
				System.out.println();
				
			}
			
		}
	
		static HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> map) {
			LinkedList<Entry<Character, Integer>> list = new LinkedList<Entry<Character, Integer>>(map.entrySet());
			Collections.sort(list, new CompByNumber());
			LinkedHashMap<Character, Integer> sorted = new LinkedHashMap<Character, Integer>();
			for (Entry<Character, Integer> entry : list) {
				sorted.put(entry.getKey(), entry.getValue());
			}
			
	     return sorted;
		}
}
