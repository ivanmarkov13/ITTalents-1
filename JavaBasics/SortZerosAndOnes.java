
public class SortZerosAndOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {1,0,1,0,1,1,1,1,0,0,1,0,1,0,1,0,0,1,0};
		int ones = 0;
		int zeros = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==1) {
				ones++;
			}
			if(arr[i]==0) {
				zeros++;
			}
		}
		
		for (int i = 0; i < zeros; i++) {
			System.out.print(0 + " ");
		}
		for (int i = 0; i < ones; i++) {
			System.out.print(1 + " ");
		}

	}

}
