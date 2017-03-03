
public class StringFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "Imalo edno vreme edna baba i edna mechka.";
		
		String [] arr = a.split(" ");
		int maxLength = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (maxLength<arr[i].length()) {
				maxLength = arr[i].length();
			}
		}
		
		for (int i = 0; i < maxLength+2; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for (int i = 0; i < arr.length; i++) {
			while (arr[i].length()<maxLength) {
				arr[i] = arr[i].concat(" ");
			}
			System.out.println("*" + arr[i] + "*");
		}
		for (int i = 0; i < maxLength+2; i++) {
			System.out.print("*");
		}
		
		
		

	}

}
