import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {5,4,6,9,2,5,8,5,5,2,4,3,4,3};
		countingSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	static void countingSort (int [] arr) {
		int min = arr[0];
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (min >arr[i]) {
				min = arr[i];
			}
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		int [] helper = new int [max-min+1];
		for (int i = 0; i < arr.length; i++) {
			int stoinost = arr[i];
			helper[stoinost-min]++;
		}
		int originalIndex = 0;
		
		for (int i = 0; i < helper.length; i++) {
			int counter = helper[i];
			for (int j = 0; j < counter; j++) {
				arr[originalIndex] = i+min;
				originalIndex++;
			}
		}

	}
}
