
public class MostFrequentString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "hello world how are you world";
		String [] b = a.split(" ");
		String mostFrequent=" ";
		int counter=0;
		int counter1=0;
		
		for (int i = 0; i < b.length; i++) {
			for (int j = i+1; j < b.length; j++) {
			if (b[i].equals(b[j])) {
					counter++;
				}
			}
			if (counter1<counter) {
				counter1=counter;
				mostFrequent = b[i];
			}
			counter=0;
		}
		System.out.println(mostFrequent);
		System.out.println(counter1);
		if(mostFrequent.equals(" ")) {
			System.out.println("There is no word that is repeated more than once");
		}
	}

}
