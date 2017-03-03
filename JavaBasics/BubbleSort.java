
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr = {2,5,2,6,4,0,-5,3,5,10,43,37,27,33};
		bubbleSort(arr);
		

	}
	static void bubbleSort(int[]arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean swap = false;
			for (int j = 0; j < arr.length-1-i; j++) {
				if(arr[j] >= arr[j+1]) {
					int temp = arr[j];
					arr[j]= arr[j+1];
					arr[j+1] = temp;
					swap=true;
				}
			}
			if(!swap) {
				break;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
