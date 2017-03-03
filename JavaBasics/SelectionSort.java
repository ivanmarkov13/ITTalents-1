import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr = {4,3,6,3,6,2,90,3,2,-5,90,45,-2,0,3,9,-6};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	static void selectionSort(int[]arr) {
		for (int i = 0; i < arr.length/2; i++) {
			int min = arr[i];
			int minIndex = i;
			int max = arr[i];
			int maxIndex = i;
			for (int j = i; j < arr.length-i; j++) {
				if (min > arr[j]) {
					min = arr[j];
					minIndex = j;
				}
				if (max < arr[j]) {
					max = arr[j];
					maxIndex = j;
				}
			}
			
			int temp1 = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp1;
			
			
			if (arr[minIndex]==max) {
				maxIndex=minIndex;
			}
			
			int temp2 = arr[arr.length-1-i];
			arr[arr.length-1-i] = arr[maxIndex];
			arr[maxIndex] = temp2;
		}
	}

}
