
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = { 1,2,9,2,4,2,14,0,34,21,16,13,8};
		print(arr);
		//int pivotIdx = partition(arr,0,arr.length-1);
		quickSort(arr,0,arr.length-1);
		print(arr);
		

	}
	
	static void quickSort (int[] arr, int start, int end) {
		if (start>=end) {
			return;
		}
		int pivotIndex = partition(arr,start,end);
		quickSort(arr,pivotIndex+1,end);
		quickSort(arr,start,pivotIndex-1);
	}
	static void print (int[]arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ((i==arr.length-1)?"": ","));
		}
		System.out.println("]");
	}
	
	static int partition (int[] arr, int start, int end) {
		int pivot = arr[end];
		int index = start;
		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				index++;
			}
		}
				int temp = arr[index];
				arr[index] = arr[end];
				arr[end] = temp;
				return index;		
	}

}
